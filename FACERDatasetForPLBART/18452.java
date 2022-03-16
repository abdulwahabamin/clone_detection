    /**
     * Returns the number of songs in the specified genre.
     */
    public int getGenreSongCount(String genreName) {
    	String selection = SONG_GENRE + "=" + "'" + genreName.replace("'", "''") + "'";
    	Cursor cursor = getDatabase().query(MUSIC_LIBRARY_TABLE, null, selection, null, null, null, null);
    	
    	int songCount = cursor.getCount();
    	cursor.close();
    	return songCount;
    	
    }

