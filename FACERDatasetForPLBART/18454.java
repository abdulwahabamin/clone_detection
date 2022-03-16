    /**
     * Returns a song based on its file path.
     */
    public Cursor getSongFromFilePath(String filePath) {
        String selection = SONG_FILE_PATH + "=" + "'" + filePath.replace("'", "''") + "'";
        return getDatabase().query(MUSIC_LIBRARY_TABLE, null, selection, null, null, null, null);
        
    }

