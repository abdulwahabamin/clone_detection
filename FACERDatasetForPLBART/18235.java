    /**
     * Downloads and stores song metadata from Google's servers.
     * 
     * @deprecated Grabbing metadata directly from Google's servers can potentially 
     * cause them to shutdown the "sj" service for this app. The official GMusic app
     * has a ContentProvider that can provide all the metadata for offline usage.
     */
     public String downloadMetadataFromGoogle() {
     /* //Retrieve a list of songs stored on Google Play Music and their metadata.
    	GMusicClientCalls gMusicClientCalls = GMusicClientCalls.getInstance(mContext);
    	try {
			songsList = gMusicClientCalls.getAllSongs(mContext.getApplicationContext());
		} catch (JSONException e) {
			return "GENERIC_EXCEPTION";
		}
    	
    	//Clear out all the current Google Play Music songs in the database.
    	DBAccessHelper libraryDBHelper = new DBAccessHelper(mContext);
    	libraryDBHelper.deleteAllGooglePlayMusicSongs();
    	
    	//Insert the songs and their metadata into Jams' local database.
    	/* To improve database insertion performance, we'll use a single transaction 
    	 * for the entire operation. SQLite journals each database insertion and 
    	 * creates a new transaction by default. We'll override this functionality 
    	 * and create a single transaction for all the database record insertions. 
    	 * In theory, this should reduce NAND memory overhead times and result in 
    	 * a 2x to 5x performance increase.
    	 *\/
    	try {
    		//We'll initialize the DB transaction manually.
    		libraryDBHelper.getWritableDatabase().beginTransaction();
    		
    		/* Now that we have a list of all the audio files that are either new or 
    		 * modified, we can just delete all the records of those files in the DB 
    		 * and re-add them.
    		 *\/
    		
    		//Avoid "Divide by zero" errors.
    		int scanningSongsIncrement;
    		if (songsList.size()!=0) {
    			scanningSongsIncrement = 800000/songsList.size();
    		} else {
    			scanningSongsIncrement = 800000/1;
    		}
    		
    		currentTask = mContext.getResources().getString(R.string.downloading_songs_info_from_google_play_music);
            for (int i=0; i < songsList.size(); i++) {
            	
            	WebClientSongsSchema song = songsList.get(i);
            	
            	currentProgressValue = currentProgressValue + scanningSongsIncrement;
            	publishProgress();
            	
            	//Get the song's metadata.
            	String songTitle = song.getTitle();
            	String songArtist = song.getArtist();
            	String songAlbum = song.getAlbum();
            	String songAlbumArtist = song.getAlbumArtist();
            	String songDuration = "" + song.getDurationMillis();
            	String songTrackNumber = "" + song.getTrack();
            	String songYear = "" + song.getYear();
            	String songGenre = song.getGenre();
            	String songPlayCount = "" + song.getPlayCount();
            	String songRating = "" + song.getRating();
            	String songSource = DBAccessHelper.GMUSIC;
            	String songAlbumArtPath = song.getAlbumArtUrl();
            	String songDeleted = "" + song.isDeleted();
            	String songLastPlayed = "" + song.getLastPlayed();
            	String songId = "" + song.getId();
            	
            	/* By default, Google will return an album art path that contains
            	 * an image that is 130x130 in size. The "=sxxx" parameter determines 
            	 * the size of the returned image. We'll replace all instances of "=s130" 
            	 * with "=s512" to get artwork that is 512x512 in size. Also, the "http://" 
            	 * part appears truncated, so add that into the beginning of the url.
            	 *\/
            	if (songAlbumArtPath!=null) {
            		
            		if (!songAlbumArtPath.isEmpty()) {
            			songAlbumArtPath = songAlbumArtPath.replace("=s130", "=s512");
            			songAlbumArtPath = "http:" + songAlbumArtPath;
            			
            		}
            		
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
            	
            	String songFilePath = "";
            	try {
            		URI uri = gMusicClientCalls.getSongStream(song.getId());
					songFilePath = uri.toURL().toString();
				} catch (JSONException e) {
					continue;
				} catch (URISyntaxException e) {
					continue;
				} catch (MalformedURLException e) {
					continue;
				} catch (Exception e) {
					continue;
				}
            	
            	ContentValues values = new ContentValues();
            	values.put(DBAccessHelper.SONG_TITLE, songTitle);
            	values.put(DBAccessHelper.SONG_ARTIST, songArtist);
            	values.put(DBAccessHelper.SONG_ALBUM, songAlbum);
            	values.put(DBAccessHelper.SONG_ALBUM_ARTIST, songAlbumArtist);
            	values.put(DBAccessHelper.SONG_DURATION, songDuration);
            	values.put(DBAccessHelper.SONG_FILE_PATH, songFilePath);
            	values.put(DBAccessHelper.SONG_FOLDER_PATH, "");
            	values.put(DBAccessHelper.SONG_TRACK_NUMBER, songTrackNumber);
            	values.put(DBAccessHelper.SONG_GENRE, songGenre);
            	values.put(DBAccessHelper.SONG_PLAY_COUNT, songPlayCount);
            	values.put(DBAccessHelper.SONG_YEAR, songYear);
            	values.put(DBAccessHelper.SONG_LAST_MODIFIED, "");
            	values.put(DBAccessHelper.BLACKLIST_STATUS, "FALSE"); //Keep the song whitelisted by default.
            	values.put(DBAccessHelper.ADDED_TIMESTAMP, date.getTime());
            	values.put(DBAccessHelper.RATING, songRating);
            	values.put(DBAccessHelper.LAST_PLAYED_TIMESTAMP, songLastPlayed);
            	values.put(DBAccessHelper.SONG_SOURCE, songSource);
            	values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, songAlbumArtPath);
            	values.put(DBAccessHelper.SONG_DELETED, songDeleted);
            	values.put(DBAccessHelper.SONG_ID, songId);
            	
            	/* We're gonna have to save the song ID into the SONG_FILE_PATH 
            	 * field. Google Play Music playlist songs don't have a file path, but we're using a 
            	 * JOIN in PlaylistsFlippedFragment that relies on this field, so we'll need to use the 
            	 * song ID as a placeholder instead.
            	 *\/
            	values.put(DBAccessHelper.SONG_FILE_PATH, songId);
            	
            	//Add all the entries to the database to build the songs library.
            	libraryDBHelper.getWritableDatabase().insert(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
            												 null, 
            												 values);	
            	
            }
            
            libraryDBHelper.getWritableDatabase().setTransactionSuccessful();
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated method stub.
    		return "GENERIC_EXCEPTION";
    	} finally {
    		//Close the transaction.
    		libraryDBHelper.getWritableDatabase().endTransaction();
    		libraryDBHelper.close();
    	}
    	
    	/**************************************************************************
    	 * BUILD PLAYLISTS LIBRARY.
    	 **************************************************************************\/
    	//Clear out all the current Google Play Music playlists in the database.
    	DBAccessHelper musicLibraryPlaylistsDBHelper = new DBAccessHelper(mContext);
    	musicLibraryPlaylistsDBHelper.deleteAllGooglePlayMusicPlaylists();
    	
    	//Insert the songs and their metadata into Jams' local database.
    	/* To improve database insertion performance, we'll use a single transaction 
    	 * for the entire operation. SQLite journals each database insertion and 
    	 * creates a new transaction by default. We'll override this functionality 
    	 * and create a single transaction for all the database record insertions. 
    	 * In theory, this should reduce NAND memory overhead times and result in 
    	 * a 2x to 5x performance increase.
    	 *\/
    	try {
    		//Open a connection to the database.
    		musicLibraryPlaylistsDBHelper.getWritableDatabase().beginTransaction();
    		
        	try {
    			playlistsList = gMusicClientCalls.getAllPlaylists(mContext.getApplicationContext()).getPlaylists();
    		} catch (JSONException e) {
    			return "GENERIC_EXCEPTION";
    		}

    		//Avoid "Divide by zero" errors.
    		int scanningPlaylistsIncrement;
    		if (playlistsList.size()!=0) {
    			scanningPlaylistsIncrement = 100000/playlistsList.size();
    		} else {
    			scanningPlaylistsIncrement = 100000/1;
    		}
    		currentTask = mContext.getResources().getString(R.string.syncing_with_google_play_music);
    		
    		for (int i=0; i < playlistsList.size(); i++) {

            	currentProgressValue = currentProgressValue + scanningPlaylistsIncrement;
            	publishProgress();
            	
            	//Get the playlist's metadata.
            	String playlistName = playlistsList.get(i).getTitle();
            	String playlistID = playlistsList.get(i).getPlaylistId();
            	String playlistArtUrl = "";

            	ContentValues playlistValues = new ContentValues();
            	playlistValues.put(DBAccessHelper.PLAYLIST_NAME, playlistName);
            	playlistValues.put(DBAccessHelper.PLAYLIST_ID, playlistID);
            	playlistValues.put(DBAccessHelper.PLAYLIST_ART_URL, playlistArtUrl);
            	playlistValues.put(DBAccessHelper.PLAYLIST_SOURCE, DBAccessHelper.GMUSIC);
            	playlistValues.put(DBAccessHelper.PLAYLIST_BLACKLIST_STATUS, "FALSE");
            	
            	//Add all the entries to the database to build the songs library.
            	musicLibraryPlaylistsDBHelper.getWritableDatabase().insert(DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME, 
            												 			   null, 
            												 			   playlistValues);	
            	
            }
    		
    		musicLibraryPlaylistsDBHelper.getWritableDatabase().setTransactionSuccessful();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		//Seal off all connections to the database.
    		musicLibraryPlaylistsDBHelper.getWritableDatabase().endTransaction();
    		musicLibraryPlaylistsDBHelper.close();
    	}
    	
    	//Build the genres library.
    	updateGenreSongCount();
    	
    	return "SUCCESS"; */
    	return null;
    }

