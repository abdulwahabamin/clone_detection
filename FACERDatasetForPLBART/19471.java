	/**
	 * This method combines the current cursor with the specified playlist cursor.
	 * @param newCursor
	 */
	public void enqueuePlaylistCursor(Cursor newCursor) {
		
		String[] matrixCursorColumns = { DBAccessHelper.SONG_ARTIST,  
										 DBAccessHelper.SONG_ALBUM, 
										 DBAccessHelper.SONG_TITLE, 
										 DBAccessHelper.SONG_FILE_PATH,
										 DBAccessHelper.SONG_DURATION, 
										 DBAccessHelper.SONG_GENRE, 
										 DBAccessHelper.SONG_ID, 
										 DBAccessHelper.SONG_ALBUM_ART_PATH, 
										 DBAccessHelper.SONG_SOURCE };
		
		//Create an empty matrix getCursor() with the specified columns.
		MatrixCursor mMatrixCursor = new MatrixCursor(matrixCursorColumns);
		
		//Make a copy of the old getCursor() and copy it's contents over to the matrix getCursor().
		Cursor tempCursor = getCursor();
		
		tempCursor.moveToFirst();
		MediaMetadataRetriever mMMDR = new MediaMetadataRetriever();
		for (int i=0; i < tempCursor.getCount(); i++) {
			tempCursor.moveToPosition(i);
			
			//Check which type of getCursor() the service currently has.
			if (getCursor().getColumnIndex(DBAccessHelper.SONG_FILE_PATH)==-1) {
				
				//We'll have to manually extract the info from the audio file.
/*				String songFilePath = tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.PLAYLIST_SONG_FILE_PATH));
				
				try {
					mMMDR.setDataSource(songFilePath);
				} catch (Exception e) {
					//Skip the song if there's a problem with reading it.
					continue;
				}*/
				
				String songArtist = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
				String songAlbum = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
				String songTitle = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
				String songDuration = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
				String songGenre = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
				
				mMatrixCursor.addRow(new Object[] { songArtist, 
												   songAlbum,
												   songTitle, 
												   "",
												   songDuration, 
												   songGenre });

			} else {
				
				mMatrixCursor.addRow(new Object[] { tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)), 
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_ALBUM)),
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_TITLE)), 
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH)),
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_DURATION)),
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_GENRE)), 
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_ID)), 
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH)), 
												   tempCursor.getString(tempCursor.getColumnIndex(DBAccessHelper.SONG_SOURCE)) });

			}
		
		}
		
		tempCursor.close();
		
		//Copy the contents of the new getCursor() over to the MatrixCursor.
		if (newCursor.getCount() > 0) {

			String songArtist = "";
			String songAlbum = "";
			String songTitle = "";
			String filePath = "";
			String songDuration = "";
			for (int j=0; j < newCursor.getCount(); j++) {
/*				newCursor.moveToPosition(j);
				filePath = newCursor.getString(newCursor.getColumnIndex(DBAccessHelper.PLAYLIST_SONG_FILE_PATH));
				
				try {
					mMMDR.setDataSource(filePath);
				} catch (Exception e) {
					continue;
				}*/
				
				//Get the metadata from the song file.
				songArtist = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
				songAlbum = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
				songTitle = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
				songDuration = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
				String songGenre = mMMDR.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
				
				mMatrixCursor.addRow(new Object[] { songArtist, 
						   						   songAlbum,
						   						   songTitle, 
						   						   filePath,
						   						   songDuration,
						   						   songGenre });
				
			}
			
		}
		
		mEnqueuePerformed = true;
		newCursor.close();
		mCursor = (Cursor) mMatrixCursor;
		mMatrixCursor.close();
		
	}

