    /**
     * Updates a song's "scanned" flag during the scanning process.
     */
    public void updateScannedFlag(String filePath) {
        String selection = SONG_FILE_PATH + "=" + "'" + filePath.replace("'", "''") + "'";
        
        ContentValues values = new ContentValues();
        values.put(SONG_SCANNED, "TRUE");
        
        getDatabase().update(MUSIC_LIBRARY_TABLE, values, selection, null);
     
    }

