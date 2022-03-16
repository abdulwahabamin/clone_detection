    /**
     * Returns a list of all the albums sorted by name.
     */
    public Cursor getAllAlbumsOrderByName() {
        String selectQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
							 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + 
							 SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONG_ALBUM_ARTIST +
							 " FROM " + MUSIC_LIBRARY_TABLE + " WHERE " + 
							 BLACKLIST_STATUS + "=" + "'" + 
							 "0" + "'" + " GROUP BY " + 
							 SONG_ALBUM + " ORDER BY " + SONG_ALBUM
							 + " ASC";
     
        return getDatabase().rawQuery(selectQuery, null);
        
    }

