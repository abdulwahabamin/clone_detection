    /**
     * Returns the album art path of the specified song.
     */
    public String getAlbumArtBySongId(String songId) {
    	String where = SONG_ID + "=" + "'" + songId + "'";
    	Cursor cursor = getDatabase().query(MUSIC_LIBRARY_TABLE, 
    											new String[] { _ID, SONG_ALBUM_ART_PATH }, 
    											where, 
    											null, 
    											null, 
    											null, 
    											null);
    	
    	if (cursor!=null) {
    		cursor.moveToFirst();
    		String albumArtPath = cursor.getString(cursor.getColumnIndex(SONG_ALBUM_ART_PATH));
    		cursor.close();
    		return albumArtPath;
    	} else {    		
    		return null;
    	}
    	
    }

