    /**
     * Returns a list of all blacklisted songs.
     */
    public Cursor getAllBlacklistedSongs() {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + 
        					 " WHERE " + BLACKLIST_STATUS + "=" + "'1'" + 
        					 " ORDER BY " + SONG_TITLE + " ASC";
     
        return getDatabase().rawQuery(selectQuery, null);
        
    }

