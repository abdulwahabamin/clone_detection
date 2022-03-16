    /**
     * Returns a selection cursor of all unique genres.
     */
    public Cursor getAllUniqueGenres(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_GENRE + "), " + 
    								 _ID + ", " + SONG_FILE_PATH + ", " + SONG_ALBUM_ART_PATH
    								 + ", " + SONG_DURATION + ", " + SONG_SOURCE + ", " + GENRE_SONG_COUNT + " FROM " + 
    								 MUSIC_LIBRARY_TABLE + " WHERE " + 
    								 BLACKLIST_STATUS + "=" + "'" + 
    								 "0" + "'" + selection + " GROUP BY " + 
    								 SONG_GENRE + " ORDER BY " + SONG_GENRE 
    								 + " ASC";
    			
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

