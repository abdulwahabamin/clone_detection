    @Override
    protected Void doInBackground(String... params) {
    	
    	if (params.length==2) {
    		artist = params[0];
    		album = params[1];
    	}
    	
		/*
		 * Loop through the songs table and retrieve the data paths of all the songs (used to embed the artwork).
		 */
		
		//Remove the + and replace them back with spaces. Also replace any rogue apostrophes.
		try {
			if (album.contains("+")) {
				album = album.replace("+", " ");
			}
			
			if (album.contains("'")) {
				album = album.replace("'", "''");
			}
		
			if (artist.contains("+")) {
				artist = artist.replace("+", " ");
			}
			
			if (artist.contains("'")) {
				artist = artist.replace("'", "''");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		String selection = DBAccessHelper.SONG_ALBUM + "=" + "'" + album + "'" + " AND "
						 + DBAccessHelper.SONG_ARTIST + "=" + "'" + artist + "'";
		
		String[] projection = { DBAccessHelper._ID, 
								DBAccessHelper.SONG_FILE_PATH, 
								DBAccessHelper.SONG_ALBUM_ART_PATH };
		
		Cursor cursor = mApp.getDBAccessHelper().getWritableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
											 				 				 projection, 
											 				 				 selection, 
											 				 				 null, 
											 				 				 null,
											 				 				 null, 
											 				 				 null);
		
		cursor.moveToFirst();
		if (cursor.getCount()!=0) {
			dataURIsList.add(cursor.getString(1));
			albumArtPathsList.add(cursor.getString(2));
		}
		
		while(cursor.moveToNext()) {
			dataURIsList.add(cursor.getString(1));
			albumArtPathsList.add(cursor.getString(2));
		}
		
		for (int i=0; i < dataURIsList.size(); i++) {
	       	
	       	File audioFile = new File(dataURIsList.get(i));
    		AudioFile f = null;
    		
			try {
				f = AudioFileIO.read(audioFile);
			} catch (CannotReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ReadOnlyFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAudioFrameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Tag tag = null;
			if (f!=null) {
				tag = f.getTag();
			} else {
				continue;
			}
			
    		try {
    			tag.deleteArtworkField();
    		} catch (KeyNotFoundException e) {
    			Toast.makeText(mContext, R.string.album_doesnt_have_artwork, Toast.LENGTH_LONG).show();
    		}
    		
    		try {
				f.commit();
			} catch (CannotWriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		//Check if the current song's album art is a JPEG file.
    		if (albumArtPathsList.get(i).startsWith("/")) {
    			File file = new File(albumArtPathsList.get(i));
    			if (file!=null) {
    				if (file.exists()) {
    					file.delete();
    				}
    				
    			}
    			
    		}
    		
    		//Remove the album art from the album art database.
    		String filePath = dataURIsList.get(i);
    		filePath = filePath.replace("'", "''");
    		String where = DBAccessHelper.SONG_FILE_PATH + "=" + "'" + filePath + "'";
    		
    		ContentValues values = new ContentValues();
    		values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, "");
    		mApp.getDBAccessHelper().getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
    											  				  values, 
    											  				  where, 
    											  				  null);
    		
		}
		
		//Refresh the memory/disk cache.
		mApp.getImageLoader().clearDiscCache();
		mApp.getImageLoader().clearMemoryCache();
		
		cursor.close();
		cursor = null;
		
    	return null;
	    
    }

