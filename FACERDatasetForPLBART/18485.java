    /**
     * Returns a cursor with unique albums within the database, regardless of the blacklist status.
     */
    public Cursor getAllUniqueAlbumsNoBlacklist(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
    								 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + BLACKLIST_STATUS + ", " + 
    								 SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONG_ALBUM_ARTIST +
    								 " FROM " + MUSIC_LIBRARY_TABLE + " GROUP BY " + 
    								 SONG_ALBUM + " ORDER BY " + SONG_ALBUM
    								 + " ASC";
    			
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

