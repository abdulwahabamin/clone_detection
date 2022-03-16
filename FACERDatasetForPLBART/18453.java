    /**
     * Insert the number of songs within a specifed genre.
     */
    public void insertNumberOfSongsInGenre(String genre, int songCount) {
    	ContentValues values = new ContentValues();
		values.put(DBAccessHelper.GENRE_SONG_COUNT, songCount);
		String where = DBAccessHelper.SONG_GENRE + "=" + "'" + genre + "'";
		
		getDatabase().update(MUSIC_LIBRARY_TABLE, 
				  				 values, 
				  				 where, 
				  				 null);
		
    }

