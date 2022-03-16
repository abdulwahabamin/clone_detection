    /**
     * Returns a cursor with the top 25 played tracks in the library.
     */
    public Cursor getTop25PlayedTracks(String selection) {
    	return getDatabase().query(MUSIC_LIBRARY_TABLE, 
								 	   null, 
								 	   selection, 
								 	   null, 
								 	   null,
								 	   null,
								 	   SONG_PLAY_COUNT + "*1 DESC",
								 	   "25");
    	
    }

