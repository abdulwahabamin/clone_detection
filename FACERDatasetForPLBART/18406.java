    /**
     * Returns a cursor with all music folder paths in the table.
     */
    public Cursor getAllMusicFolderPaths() {
        String selectQuery = "SELECT  * FROM " + MUSIC_FOLDERS_TABLE 
        				   + " ORDER BY " + INCLUDE + "*1 DESC";
        
        return getDatabase().rawQuery(selectQuery, null);
    }

