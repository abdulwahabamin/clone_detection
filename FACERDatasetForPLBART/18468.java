    /**
     * Sets the blacklist status of the specified album.
     */
    public void setBlacklistForAlbum(String albumName, String artistName, boolean blacklist) {
    	String where = SONG_ALBUM + "=" + "'" + albumName.replace("'", "''") + "'"
    				 + " AND " + SONG_ARTIST + "=" + "'" + artistName.replace("'", "''");
    	ContentValues values = new ContentValues();
    	values.put(BLACKLIST_STATUS, blacklist);
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    	
    }

