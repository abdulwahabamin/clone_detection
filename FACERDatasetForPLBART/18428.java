    /**
     * Returns a cursor of all songs by the specified artist.
     */
    public Cursor getAllSongsByArtist(String artistName) {
    	String selection = SONG_ARTIST + "=" + "'" + artistName.replace("'", "''") + "'";
    	return getDatabase().query(MUSIC_LIBRARY_TABLE, null, selection, null, null, null, null);
    	
    }

