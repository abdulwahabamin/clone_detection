    /**
     * Returns a cursor with unique artists within the database, regardless of the blacklist status.
     */
    public Cursor getAllUniqueArtistsNoBlacklist(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ARTIST + "), " + 
    								 _ID + ", " + SONG_FILE_PATH + ", " + ARTIST_ART_LOCATION + ", " + BLACKLIST_STATUS + ", "
    								 + SONG_SOURCE + ", " + SONG_ALBUM_ART_PATH + " FROM " + MUSIC_LIBRARY_TABLE 
    								 + " GROUP BY " + SONG_ARTIST + " ORDER BY " + SONG_ARTIST + " ASC";
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

