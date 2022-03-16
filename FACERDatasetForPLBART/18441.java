    /**
     * Returns a cursor with all the songs in the specified genre.
     */
    public Cursor getAllSongsInGenre(String selection) {
    	String selectQuery = "SELECT * FROM " + MUSIC_LIBRARY_TABLE
    					   + " WHERE " + BLACKLIST_STATUS + "=" + "'"
    					   + "0" + "'" + selection + " ORDER BY " + SONG_ALBUM + " ASC, " 
    					   + SONG_TRACK_NUMBER + "*1 ASC";

    	return getDatabase().rawQuery(selectQuery, null);
    	
    }

