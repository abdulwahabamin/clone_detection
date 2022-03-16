    /**
     * Returns a cursor with all songs, ordered by their rating.
     */
    public Cursor getTopRatedSongs(String selection) {
    	return getDatabase().query(MUSIC_LIBRARY_TABLE,
    							 	   null,
    							 	   selection,
    							 	   null,
    							 	   null,
    							 	   null,
    							 	   RATING + "*1 DESC",
    							 	   "25");
    	
    }

