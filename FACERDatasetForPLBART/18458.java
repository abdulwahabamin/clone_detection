    /**
     * Resets the SONG_SCANNED flag for all songs.
     */
    public void resetSongScannedFlags() {
    	ContentValues values = new ContentValues();
    	values.put(SONG_SCANNED, "FALSE");
    	
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, null, null);

    }

