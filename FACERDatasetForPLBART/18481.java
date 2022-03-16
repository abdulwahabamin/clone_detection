    /**
     * Returns a cursor with the specified song.
     */
    public Cursor getSongById(String songID) {
    	String selection = SONG_ID + "=" + "'" +  songID + "'";
    	return getDatabase().query(MUSIC_LIBRARY_TABLE, null, selection, null, null, null, null);
	 
    }

