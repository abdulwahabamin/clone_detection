    @Override
    protected Void doInBackground(String... params) {
    	
		Cursor songsCursor = mApp.getDBAccessHelper().getAllSongsByArtist(mArtist);
		
		//Loop through the songs and add them to the EQ settings DB with the current EQ settings.
		if (songsCursor!=null && songsCursor.getCount() > 0) {
			
			for (int j=0; j < songsCursor.getCount(); j++) {
				songsCursor.moveToPosition(j);
				
				String songId = songsCursor.getString(songsCursor.getColumnIndex(DBAccessHelper.SONG_ID));
				saveSettingsToDB(songId);
				
			}
			
		}

		if (songsCursor!=null)
			songsCursor.close();
		
    	return null;
	    
    }

