    /**
     * Returns a list of all the artists sorted by name.
     */
    public Cursor getAllArtistsOrderByName() {

        String selectQuery = "SELECT DISTINCT(" + SONG_ARTIST + "), " + 
							 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + 
							 SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONG_ALBUM_ARTIST +
							 " FROM " + MUSIC_LIBRARY_TABLE + " WHERE " + 
							 BLACKLIST_STATUS + "=" + "'" + 
							 "0" + "'" + " GROUP BY " + 
							 SONG_ARTIST + " ORDER BY " + SONG_ARTIST
							 + " ASC";
     
        return getDatabase().rawQuery(selectQuery, null);
        
    }

