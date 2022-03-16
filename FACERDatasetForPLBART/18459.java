    /**
     * Returns a cursor of all songs in the specified playlist, with an additional selection parameter.
     */
    public Cursor getAllSongsInPlaylistSearchable(String selection) {
    	/*String selectQuery = "SELECT * FROM " + MUSIC_LIBRARY_TABLE
							  + " INNER JOIN " + DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME + " ON (" 
							  + MUSIC_LIBRARY_TABLE + "." + SONG_FILE_PATH + "=" 
							  + DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME + "." 
							  + DBAccessHelper.PLAYLIST_SONG_FILE_PATH + ") WHERE " + MUSIC_LIBRARY_TABLE + "."
							  + BLACKLIST_STATUS + "=" + "'" + "0" + "'" + selection + " ORDER BY " 
							  + DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME 
							  + "." + DBAccessHelper.PLAYLIST_ORDER + "*1 ASC" ;
    	
        return getDatabase().rawQuery(selectQuery, null);*/
    	return null;

    }

