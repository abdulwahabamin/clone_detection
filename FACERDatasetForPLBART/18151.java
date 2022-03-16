    @Override
    protected Void doInBackground(String... params) {
    	
		//Get a cursor with all the songs in the library.
		Cursor songsCursor = mApp.getDBAccessHelper().getAllSongs();
    	
		//Loop through the songs and add them to the EQ settings DB with the current EQ settings.
		if (songsCursor!=null && songsCursor.getCount() > 0) {
			
			for (int j=0; j < songsCursor.getCount(); j++) {
				songsCursor.moveToPosition(j);

				String songId = songsCursor.getString(songsCursor.getColumnIndex(DBAccessHelper.SONG_ID));
				mEqualizerFragment.setEQValuesForSong(songId);

			}

		}
    	
		if (songsCursor!=null)
			songsCursor.close();
		
    	return null;
	    
    }

