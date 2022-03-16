    /**
     * Returns a cursor with all songs, ordered by their add date.
     */
    public Cursor getRecentlyAddedSongs(String selection) {
    	return getDatabase().query(MUSIC_LIBRARY_TABLE,
    							 	   null,
    							 	   selection,
    							 	   null,
    							 	   null,
    							 	   null,
    							 	   ADDED_TIMESTAMP + "*1 DESC",
    								   "25");
    	
    }

