    /**
     * Deletes a song that has the specified file path.
     */
    public void deleteSongByFilePath(String filePath) {
        String selection = SONG_FILE_PATH + "=" + "'" + filePath.replace("'", "''") +"'";
        getDatabase().delete(MUSIC_LIBRARY_TABLE, selection, null);
        
    }

