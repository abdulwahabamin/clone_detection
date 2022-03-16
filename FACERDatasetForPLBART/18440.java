    /**
     * Returns a selection cursor of all unique genres in the 
     * specified library. The library should be specified in the 
     * selection parameter.
     */
    public Cursor getAllUniqueGenresInLibrary(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_GENRE + "), "+ MUSIC_LIBRARY_TABLE + "." +
									 _ID + ", " + SONG_FILE_PATH + ", " + SONG_ALBUM_ART_PATH + ", " + SONG_DURATION
									 + ", " + SONG_SOURCE + ", " + GENRE_SONG_COUNT + " FROM " + MUSIC_LIBRARY_TABLE 
									 + " INNER JOIN " + LIBRARIES_TABLE + " ON (" 
									 + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + LIBRARIES_TABLE + "." 
									 + SONG_ID + ") WHERE " + 
    								 BLACKLIST_STATUS + "=" + "'" + 
    								 "0" + "'" + selection + " GROUP BY " + 
    								 SONG_GENRE + " ORDER BY " + SONG_GENRE 
    								 + " ASC";
    			
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

