    /**
     * Returns a selection cursor of all songs in the 
     * specified library. The library should be specified in the 
     * selection parameter.
     */
    public Cursor getAllSongsInLibrarySearchable(String selection) {
    	String selectQuery = "SELECT * FROM " + MUSIC_LIBRARY_TABLE 
							  + " INNER JOIN " + LIBRARY_NAME + " ON (" 
							  + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + LIBRARY_NAME + "." 
							  + SONG_ID + ") WHERE " + MUSIC_LIBRARY_TABLE + "." +
                                BLACKLIST_STATUS + "=" + "'" + "0" + "'" + selection;
    	
        return getDatabase().rawQuery(selectQuery, null);
    }

