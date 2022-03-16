    /**
     * Returns a cursor of all songs in the specified album by the 
     * specified artist.
     */
    public Cursor getAllSongsInAlbum(String albumName, String artistName) {
    	String selection = SONG_ALBUM + "=" + "'" 
    					 + albumName.replace("'", "''") 
    					 + "'" + " AND " + SONG_ARTIST 
    					 + "=" + "'" + artistName.replace("'", "''") 
    					 + "'";
    	
    	return getDatabase().query(MUSIC_LIBRARY_TABLE, null, selection, null, null, null, null);
    	
    }

