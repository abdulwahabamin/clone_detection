    /**
     * Returns a cursor of all blacklisted artists.
     */
    public Cursor getBlacklistedArtists() {
    	String query = "SELECT DISTINCT(" + SONG_ARTIST + "), " + 
						_ID + ", " + SONG_FILE_PATH + ", " + 
						SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONG_ALBUM_ARTIST +
						" FROM " + MUSIC_LIBRARY_TABLE + " WHERE " + 
						BLACKLIST_STATUS + "=" + "'" + 
						"1" + "'" + " GROUP BY " + 
						SONG_ALBUM + " ORDER BY " + SONG_ALBUM
						+ " ASC";
    	
    	return getDatabase().rawQuery(query, null);
    	
    }

