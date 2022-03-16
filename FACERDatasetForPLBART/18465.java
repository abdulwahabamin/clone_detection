    /**
     * Saves the last playback position for the specified song.
     */
    public void setLastPlaybackPosition(String songId, long lastPlaybackPosition) {
    	if (songId!=null) {
    		songId = songId.replace("'", "''");
    	} else {
    		return;
    	}
    	
    	String where = SONG_ID + "=" + "'" + songId + "'";
    	ContentValues values = new ContentValues();
    	values.put(SAVED_POSITION, lastPlaybackPosition);
    	
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    	
    }

