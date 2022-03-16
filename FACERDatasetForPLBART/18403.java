	/**
	 * Adds a music folder to the table.
	 */
    public void addMusicFolderPath(String folderPath) {
        //Escape any rogue apostrophes.
        if (folderPath.contains("'")) {
        	folderPath = folderPath.replace("'", "''");
        }
        
        ContentValues values = new ContentValues();
        values.put(FOLDER_PATH, folderPath);

        getDatabase().insert(MUSIC_FOLDERS_TABLE, null, values);
        
    }

