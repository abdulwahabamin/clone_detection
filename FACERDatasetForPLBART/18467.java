    /**
     * Sets the blacklist status of the specified album artist.
     */
    public void setBlacklistForAlbumArtist(String albumArtistName, boolean blacklist) {
    	String where = SONG_ALBUM_ARTIST + "=" + "'" + albumArtistName.replace("'", "''") + "'";
    	ContentValues values = new ContentValues();
    	values.put(BLACKLIST_STATUS, blacklist);
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    	
    }

