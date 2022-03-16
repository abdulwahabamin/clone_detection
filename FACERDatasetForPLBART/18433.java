    /**
     * Returns a selection cursor of all unique albums.
     */
    public Cursor getAllUniqueAlbums(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
    								 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + BLACKLIST_STATUS + ", " + 
    								 SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONG_ALBUM_ARTIST + ", " + SONG_DURATION +
    								 " FROM " + MUSIC_LIBRARY_TABLE + " WHERE " + 
    								 BLACKLIST_STATUS + "=" + "'" + 
    								 "0" + "'" + selection + " GROUP BY " + 
    								 SONG_ALBUM + " ORDER BY " + SONG_ALBUM
    								 + " ASC";
    			
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

