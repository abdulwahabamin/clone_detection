    /**
     * Returns a cursor of all blacklisted albmums.
     */
    public Cursor getBlacklistedAlbums() {
    	String query = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
						_ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + 
						SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONG_ALBUM_ARTIST +
						" FROM " + MUSIC_LIBRARY_TABLE + " WHERE " + 
						BLACKLIST_STATUS + "=" + "'" + 
						"1" + "'" + " GROUP BY " + 
						SONG_ALBUM + " ORDER BY " + SONG_ALBUM
						+ " ASC";
    	
    	return getDatabase().rawQuery(query, null);
    	
    }

