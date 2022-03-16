   /**
    * Deletes all music folders from the table.
    */
    public void deleteAllMusicFolderPaths() {
        getDatabase().delete(MUSIC_FOLDERS_TABLE, null, null);
    }

