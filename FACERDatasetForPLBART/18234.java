	public String getMetadataFromGooglePlayMusicApp() {
    	
    	//Grab a handle on the mApp.
    	Uri googlePlayMusicContentProviderUri = Uri.parse("content://com.google.android.music.MusicContent/audio");
    	String[] projection = { "title", "artist", "album", "AlbumArtist",
    							"duration", "track", "year", "Genre", "TrackType AS track_type",
    							/*"_count",*/ "Rating", "AlbumArtLocation AS album_art", "SourceType AS source_type",
    							"SourceId", "ArtistArtLocation", /*, "artistId",*/ "StoreAlbumId" };
    	
    	/* source_type values:
    	 * 0: Local file (not used).
    	 * 1: Unknown.
    	 * 2: Personal, free GMusic library (used).
    	 * 3: All Access (not used).
    	 */
    	String selection = "source_type=2 AND track_type=0";
    	
    	//Catch any exceptions that may be thrown as a result of unknown columns in GMusic's content mApp.
    	Cursor cursor = null;
    	boolean projectionFailed = false;
    	try {
    		cursor = mContext.getContentResolver().query(googlePlayMusicContentProviderUri, projection, selection, null, null);
    	} catch (IllegalArgumentException e) {
    		e.printStackTrace();
    		
    		//Problematic columns are commented out here.
    		String[] failSafeProjection = { "title", "artist", "album", "AlbumArtist",
						   					"duration", "track", "year", "Genre", "TrackType AS track_type",
						   					/*"_count",*/ "Rating", "AlbumArtLocation AS album_art", /* "SourceType AS source_type", */
						   					"SourceId", /* "ArtistArtLocation", "artistId",*/ "StoreAlbumId" };
    		
    		cursor = mContext.getContentResolver().query(googlePlayMusicContentProviderUri, failSafeProjection, "track_type=0", null, null);
    		projectionFailed = true;
    		
    	}

    	//Clear out all the current Google Play Music songs in the database.
    	mApp.getDBAccessHelper().deleteAllGooglePlayMusicSongs();
    	
    	//Insert the songs and their metadata into Jams' local database.
    	/* To improve database insertion performance, we'll use a single transaction 
    	 * for the entire operation. SQLite journals each database insertion and 
    	 * creates a new transaction by default. We'll override this functionality 
    	 * and create a single transaction for all the database record insertions. 
    	 * In theory, this should reduce NAND memory overhead times and result in 
    	 * a 2x to 5x performance increase.
    	 */
    	try {
    		//We'll initialize the DB transaction manually.
    		mApp.getDBAccessHelper().getWritableDatabase().beginTransaction();

    		//Avoid "Divide by zero" errors.
    		int scanningSongsIncrement;
    		if (cursor!=null) {
        		if (cursor.getCount()!=0) {
        			scanningSongsIncrement = 800000/cursor.getCount();
        		} else {
        			scanningSongsIncrement = 800000/1;
        		}
        		
    		} else {
    			return "FAIL";
    		}
    		
    		currentTask = mContext.getResources().getString(R.string.syncing_with_google_play_music);
            for (int i=0; i < cursor.getCount(); i++) {
            	
            	cursor.moveToPosition(i);
            	currentProgressValue = currentProgressValue + scanningSongsIncrement;
            	publishProgress();
            	
            	//Get the song's metadata.
            	String songTitle = cursor.getString(cursor.getColumnIndex("title"));
            	String songArtist = cursor.getString(cursor.getColumnIndex("Artist"));
            	String songAlbum = cursor.getString(cursor.getColumnIndex("Album"));
            	String songAlbumArtist = cursor.getString(cursor.getColumnIndex("AlbumArtist"));
            	String songDuration = cursor.getString(cursor.getColumnIndex("Duration"));
            	String songTrackNumber =cursor.getString(cursor.getColumnIndex("Track"));
            	String songYear = cursor.getString(cursor.getColumnIndex("Year"));
            	String songGenre = cursor.getString(cursor.getColumnIndex("Genre"));
            	//String songPlayCount = cursor.getString(cursor.getColumnIndex("_count"));
            	String songRating = cursor.getString(cursor.getColumnIndex("Rating"));
            	String songSource = DBAccessHelper.GMUSIC;
            	String songAlbumArtPath = cursor.getString(cursor.getColumnIndex("album_art"));
            	String songID = cursor.getString(cursor.getColumnIndex("SourceId"));
            	//String artistID = cursor.getString(cursor.getColumnIndex("artistId"));
            	String storeAlbumID = cursor.getString(cursor.getColumnIndex("StoreAlbumId"));
            	
            	String songArtistArtPath = "";
            	if (projectionFailed==false) {
            		songArtistArtPath = cursor.getString(cursor.getColumnIndex("ArtistArtLocation"));
            	} else {
            		//Fall back on album art.
            		songArtistArtPath = cursor.getString(cursor.getColumnIndex("album_art"));
            	}
            	
            	//Prepare the genres ArrayList.
            	if (!genresList.contains(songGenre)) {
            		genresList.add(songGenre);
            	}
            	
            	//Filter out track numbers and remove any bogus values.
            	if (songTrackNumber!=null) {
        			if (songTrackNumber.contains("/")) {
        				int index = songTrackNumber.lastIndexOf("/");
        				songTrackNumber = songTrackNumber.substring(0, index);
        			}
                	
            	}
            	
            	if (songYear.equals("0")) {
            		songYear = "";
            	}
            	
            	//Check if any of the other tags were empty/null and set them to "Unknown xxx" values.
            	if (songArtist==null || songArtist.isEmpty() || songArtist.equals(" ")) {
            		songArtist = "Unknown Artist";
            	}
            	
            	if (songAlbumArtist==null || songAlbumArtist.isEmpty() || songAlbumArtist.equals(" ")) {
            		songAlbumArtist = "Unknown Album Artist";
            	}
            	
            	if (songAlbum==null || songAlbum.isEmpty() || songAlbum.equals(" ")) {
            		songAlbum = "Unknown Album";
            	}
            	
            	if (songGenre==null || songGenre.isEmpty() || songGenre.equals(" ")) {
            		songGenre = "Unknown Genre";
            	}
            	
            	ContentValues values = new ContentValues();
            	values.put(DBAccessHelper.SONG_TITLE, songTitle);
            	values.put(DBAccessHelper.SONG_ARTIST, songArtist);
            	values.put(DBAccessHelper.SONG_ALBUM, songAlbum);
            	values.put(DBAccessHelper.SONG_ALBUM_ARTIST, songAlbumArtist);
            	values.put(DBAccessHelper.SONG_DURATION, songDuration);
            	values.put(DBAccessHelper.SONG_FILE_PATH, songID);
            	values.put(DBAccessHelper.SONG_TRACK_NUMBER, songTrackNumber);
            	values.put(DBAccessHelper.SONG_GENRE, songGenre);
            	//values.put(DBAccessHelper.SONG_PLAY_COUNT, songPlayCount);
            	values.put(DBAccessHelper.SONG_YEAR, songYear);
            	values.put(DBAccessHelper.SONG_LAST_MODIFIED, "");
            	values.put(DBAccessHelper.BLACKLIST_STATUS, "FALSE"); //Keep the song whitelisted by default.
            	values.put(DBAccessHelper.ADDED_TIMESTAMP, date.getTime());
            	values.put(DBAccessHelper.RATING, songRating);
            	values.put(DBAccessHelper.SONG_SOURCE, songSource);
            	values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, songAlbumArtPath);
            	values.put(DBAccessHelper.SONG_ID, songID);
            	values.put(DBAccessHelper.ARTIST_ART_LOCATION, songArtistArtPath);
            	//values.put(DBAccessHelper.ARTIST_ID, artistID);
            	values.put(DBAccessHelper.ALBUM_ID, storeAlbumID);
            	
            	/* We're gonna have to save the song ID into the SONG_FILE_PATH 
            	 * field. Google Play Music playlist songs don't have a file path, but we're using a 
            	 * JOIN in PlaylistsFlippedFragment that relies on this field, so we'll need to use the 
            	 * song ID as a placeholder instead.
            	 */
            	values.put(DBAccessHelper.SONG_FILE_PATH, songID);
            	
            	//Add all the entries to the database to build the songs library.
            	mApp.getDBAccessHelper().getWritableDatabase().insert(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
            												 		  null, 
            												 		  values);	
            	
            }
            
            mApp.getDBAccessHelper().getWritableDatabase().setTransactionSuccessful();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		//Close the transaction.
    		mApp.getDBAccessHelper().getWritableDatabase().endTransaction();
    		
    		if (cursor!=null) {
    			cursor.close();
    			cursor = null;
    		}
    		
    	}
    	
    	/****************************************************************************
    	 * BUILD PLAYLISTS LIBRARY
    	 ****************************************************************************/
    	//getPlaylistsWebClient();
    	//getPlaylistsMobileClient();
    	
    	//Update the genres library.
    	updateGenreSongCount();
    	
    	return "SUCCESS";
    }

