    @Override
    protected Void doInBackground(String... params) {
    	
    	int which = Integer.parseInt(params[0]);
    	
        //Get a cursor with the list of all albums.
        final Cursor cursor = mApp.getDBAccessHelper().getAllUniqueAlbums("");
    	
        //Get a list of all songs in the album.
		cursor.moveToPosition(which);
		String albumName = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ALBUM));
		String artistName = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
		
		Cursor songsCursor = mApp.getDBAccessHelper().getAllSongsInAlbum(albumName, artistName);
		
		//Loop through the songs and add them to the EQ settings DB with the current EQ settings.
		if (songsCursor!=null && songsCursor.getCount() > 0) {
			
			for (int j=0; j < songsCursor.getCount(); j++) {
				songsCursor.moveToPosition(j);
				String songId = songsCursor.getString(songsCursor.getColumnIndex(DBAccessHelper.SONG_ID));
				
				saveSettingsToDB(songId);
				
			}
			
		}
		
		cursor.close();
		songsCursor.close();
    	
    	return null;
	    
    }

