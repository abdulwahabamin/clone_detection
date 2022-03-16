    /**
     * Sets the blacklist status of the specified song.
     */
    public void setBlacklistForSong(String songId, boolean blacklist) {
    	String where = SONG_ID + "=" + "'" + songId + "'";
    	ContentValues values = new ContentValues();
    	values.put(BLACKLIST_STATUS, blacklist);
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    	
    }

