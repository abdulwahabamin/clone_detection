    /**
     * Sets the blacklist status of the specified artist.
     */
    public void setBlacklistForArtist(String artistName, boolean blacklist) {
    	String where = SONG_ARTIST + "=" + "'" + artistName.replace("'", "''") + "'";
    	ContentValues values = new ContentValues();
    	values.put(BLACKLIST_STATUS, blacklist);
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    	
    }

