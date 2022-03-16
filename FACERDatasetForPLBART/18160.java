    @Override
    protected Void doInBackground(String... params) {
    	
    	int which = Integer.parseInt(params[0]);
    	
        //Get a cursor with the list of all genres.
        final Cursor cursor = mApp.getDBAccessHelper().getAllUniqueGenres("");
        cursor.moveToPosition(which);
        String selectedGenre = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_GENRE));
        cursor.close();

        String genreQuery = " AND " + DBAccessHelper.SONG_GENRE + "=" + "'"+selectedGenre+"'";

        //Get a cursor with all the songs in the specified genre.
        final Cursor songsCursor = mApp.getDBAccessHelper().getAllSongsInGenre(genreQuery);
		
		//Loop through the songs in the genre and add them to the EQ settings DB with the current EQ settings.
		if (songsCursor!=null && songsCursor.getCount() > 0) {

			for (int j=0; j < songsCursor.getCount(); j++) {
				songsCursor.moveToPosition(j);
				
				String songId = songsCursor.getString(songsCursor.getColumnIndex(DBAccessHelper.SONG_ID));
				saveSettingsToDB(songId);
				
			}
			
		}
    	
		songsCursor.close();
    	return null;
	    
    }

