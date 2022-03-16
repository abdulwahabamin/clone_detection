    /**
     * Returns a selection cursor of all songs in the database. 
     * This method can also be used to search all songs if a 
     * valid selection parameter is passed.
     */
    public Cursor getAllSongsSearchable(String selection) {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " WHERE " +
                BLACKLIST_STATUS + "=" + "'0'" + selection;

        return getDatabase().rawQuery(selectQuery, null);
    }

