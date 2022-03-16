    /**
     * Returns a cursor of all locally stored files on the device.
     */
    public Cursor getAllLocalSongs() {
    	String where = SONG_SOURCE + "='local'";
    	String[] columns = { SONG_FILE_PATH };
    	
    	return getDatabase().query(MUSIC_LIBRARY_TABLE, columns, where, null, null, null, null);
    	
    }

