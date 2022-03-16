    /**
     * Returns a cursor with all songs, ordered by their last played timestamp.
     */
    public Cursor getRecentlyPlayedSongs(String selection) {
    	return getDatabase().query(MUSIC_LIBRARY_TABLE,
    							 	   null,
    							 	   selection,
    							 	   null,
    							 	   null,
    							 	   null,
    							 	   LAST_PLAYED_TIMESTAMP + "*1 DESC",
    							 	   "25");

    }

