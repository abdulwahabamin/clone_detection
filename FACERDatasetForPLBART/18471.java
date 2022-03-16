    /**
     * Returns a cursor of all the songs in the current table.
     */
    public Cursor getAllSongs() {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " WHERE " +
        					 BLACKLIST_STATUS + "=" + "'0'" + " ORDER BY " + SONG_TITLE + " ASC";
        
        return getDatabase().rawQuery(selectQuery, null);
     
    }

