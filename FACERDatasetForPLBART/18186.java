	/**
	 * Iterates through mediaStoreCursor and transfers its data 
	 * over to Jams' private database.
	 */
	private void saveMediaStoreDataToDB(Cursor mediaStoreCursor) {
		try {
    		//Initialize the database transaction manually (improves performance).
    		mApp.getDBAccessHelper().getWritableDatabase().beginTransaction();
    		
    		//Clear out the table.
    		mApp.getDBAccessHelper()
    			.getWritableDatabase()
    			.delete(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
    					null, 
    					null);
    		
    		//Tracks the progress of this method.
    		int subProgress = 0;
    		if (mediaStoreCursor.getCount()!=0) {
    			subProgress = 250000/(mediaStoreCursor.getCount());
    		} else {
    			subProgress = 250000/1;
    		}
    		
    		//Populate a hash of all songs in MediaStore and their genres.
    		buildGenresLibrary();

            //Populate a hash of all artists and their number of albums.
            buildArtistsLibrary();

            //Populate a hash of all albums and their number of songs.
            buildAlbumsLibrary();

            //Populate a has of all albums and their album art path.
            buildMediaStoreAlbumArtHash();

    		//Prefetch each column's index.
    		final int titleColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
    		final int artistColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
    		final int albumColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            final int albumIdColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
    		final int durationColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
    		final int trackColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.TRACK);
    		final int yearColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.YEAR);
    		final int dateAddedColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED);
    		final int dateModifiedColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED);
    		final int filePathColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
    		final int idColIndex = mediaStoreCursor.getColumnIndex(MediaStore.Audio.Media._ID);
    		int albumArtistColIndex = mediaStoreCursor.getColumnIndex(MediaStoreAccessHelper.ALBUM_ARTIST);
    		
    		/* The album artist field is hidden by default and we've explictly exposed it.
    		 * The field may cease to exist at any time and if it does, use the artists 
    		 * field instead.
    		 */
    		if (albumArtistColIndex==-1) {
    			albumArtistColIndex = artistColIndex;
    		}
    		
    		//Iterate through MediaStore's cursor and save the fields to Jams' DB.
            for (int i=0; i < mediaStoreCursor.getCount(); i++) {
            	
            	mediaStoreCursor.moveToPosition(i);
            	mOverallProgress += subProgress;
            	publishProgress();
            	
            	String songTitle = mediaStoreCursor.getString(titleColIndex);
            	String songArtist = mediaStoreCursor.getString(artistColIndex);
            	String songAlbum = mediaStoreCursor.getString(albumColIndex);
                String songAlbumId = mediaStoreCursor.getString(albumIdColIndex);
            	String songAlbumArtist = mediaStoreCursor.getString(albumArtistColIndex);
            	String songFilePath = mediaStoreCursor.getString(filePathColIndex);
            	String songGenre = getSongGenre(songFilePath);
            	String songDuration = mediaStoreCursor.getString(durationColIndex);
            	String songTrackNumber = mediaStoreCursor.getString(trackColIndex);
            	String songYear = mediaStoreCursor.getString(yearColIndex);
            	String songDateAdded = mediaStoreCursor.getString(dateAddedColIndex);
            	String songDateModified = mediaStoreCursor.getString(dateModifiedColIndex);
            	String songId = mediaStoreCursor.getString(idColIndex);
                String numberOfAlbums = "" + mAlbumsCountMap.get(songArtist);
                String numberOfTracks = "" + mSongsCountMap.get(songAlbum + songArtist);
                String numberOfSongsInGenre = "" + getGenreSongsCount(songGenre);
            	String songSource = DBAccessHelper.LOCAL;
            	String songSavedPosition = "-1";

                String songAlbumArtPath = "";
                if (mMediaStoreAlbumArtMap.get(songAlbumId)!=null)
                    songAlbumArtPath = mMediaStoreAlbumArtMap.get(songAlbumId).toString();

                if (numberOfAlbums.equals("1"))
                    numberOfAlbums += " " + mContext.getResources().getString(R.string.album_small);
                else
                    numberOfAlbums += " " + mContext.getResources().getString(R.string.albums_small);

                if (numberOfTracks.equals("1"))
                    numberOfTracks += " " + mContext.getResources().getString(R.string.song_small);
                else
                    numberOfTracks += " " + mContext.getResources().getString(R.string.songs_small);

                if (numberOfSongsInGenre.equals("1"))
                    numberOfSongsInGenre += " " + mContext.getResources().getString(R.string.song_small);
                else
                    numberOfSongsInGenre += " " + mContext.getResources().getString(R.string.songs_small);

            	//Check if any of the other tags were empty/null and set them to "Unknown xxx" values.
            	if (songArtist==null || songArtist.isEmpty()) {
            		songArtist = mContext.getResources().getString(R.string.unknown_artist);
            	}
            	
            	if (songAlbumArtist==null || songAlbumArtist.isEmpty()) {
            		if (songArtist!=null && !songArtist.isEmpty()) {
            			songAlbumArtist = songArtist;
            		} else {
            			songAlbumArtist = mContext.getResources().getString(R.string.unknown_album_artist);
            		}
            		
            	}
            	
            	if (songAlbum==null || songAlbum.isEmpty()) {
            		songAlbum = mContext.getResources().getString(R.string.unknown_album);;
            	}

                if (songGenre==null || songGenre.isEmpty()) {
                    songGenre = mContext.getResources().getString(R.string.unknown_genre);
                }
            	
            	//Filter out track numbers and remove any bogus values.
            	if (songTrackNumber!=null) {
        			if (songTrackNumber.contains("/")) {
        				int index = songTrackNumber.lastIndexOf("/");
        				songTrackNumber = songTrackNumber.substring(0, index);            	
        			}

                    try {
                        if (Integer.parseInt(songTrackNumber) <= 0) {
                            songTrackNumber = "";
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        songTrackNumber = "";
                    }
                	
            	}

                long durationLong = 0;
                try {
                    durationLong = Long.parseLong(songDuration);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            	
            	ContentValues values = new ContentValues();
            	values.put(DBAccessHelper.SONG_TITLE, songTitle);
            	values.put(DBAccessHelper.SONG_ARTIST, songArtist);
            	values.put(DBAccessHelper.SONG_ALBUM, songAlbum);
            	values.put(DBAccessHelper.SONG_ALBUM_ARTIST, songAlbumArtist);
            	values.put(DBAccessHelper.SONG_DURATION, convertMillisToMinsSecs(durationLong));
            	values.put(DBAccessHelper.SONG_FILE_PATH, songFilePath);
            	values.put(DBAccessHelper.SONG_TRACK_NUMBER, songTrackNumber);
            	values.put(DBAccessHelper.SONG_GENRE, songGenre);
            	values.put(DBAccessHelper.SONG_YEAR, songYear);
                values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, songAlbumArtPath);
            	values.put(DBAccessHelper.SONG_LAST_MODIFIED, songDateModified);
                values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, songAlbumArtPath);
            	values.put(DBAccessHelper.BLACKLIST_STATUS, false);
            	values.put(DBAccessHelper.ADDED_TIMESTAMP, date.getTime());
            	values.put(DBAccessHelper.RATING, 0);
            	values.put(DBAccessHelper.LAST_PLAYED_TIMESTAMP, songDateModified);
            	values.put(DBAccessHelper.SONG_SOURCE, songSource);
            	values.put(DBAccessHelper.SONG_ID, songId);
            	values.put(DBAccessHelper.SAVED_POSITION, songSavedPosition);
                values.put(DBAccessHelper.ALBUMS_COUNT, numberOfAlbums);
                values.put(DBAccessHelper.SONGS_COUNT, numberOfTracks);
                values.put(DBAccessHelper.GENRE_SONG_COUNT, numberOfSongsInGenre);
            	
            	//Add all the entries to the database to build the songs library.
            	mApp.getDBAccessHelper().getWritableDatabase().insert(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
            												 		  null, 
            												 		  values);	
            	
            	
            }
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated method stub.
    		e.printStackTrace();
    	} finally {
    		//Close the transaction.
            mApp.getDBAccessHelper().getWritableDatabase().setTransactionSuccessful();
    		mApp.getDBAccessHelper().getWritableDatabase().endTransaction();
    	}

	}

