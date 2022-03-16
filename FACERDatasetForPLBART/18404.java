    /**
     * Deletes the specified music folder from the table.
     */
    public void deleteMusicFolderPath(String folderPath) {
        String condition = FOLDER_PATH + " = '" + folderPath + "'";
        getDatabase().delete(MUSIC_FOLDERS_TABLE, condition, null);
    }

