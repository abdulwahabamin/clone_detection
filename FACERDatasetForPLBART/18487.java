    /**
     * Returns a list of all songs irrespective of the blacklist status.
     */
    public Cursor getAllSongsNoBlacklist() {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " ORDER BY " + SONG_TITLE + " ASC";
        return getDatabase().rawQuery(selectQuery, null);
        
    }

