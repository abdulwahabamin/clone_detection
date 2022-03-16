    /**
     * Returns the local copy path for the specified song.
     */
    public String getLocalCopyPath(String songID) {
    	String[] columns = { _ID, LOCAL_COPY_PATH };
    	String where = SONG_ID + "=" + "'" + songID.replace("'", "''") + "'" + " AND " +
    				   SONG_SOURCE + "=" + "'GOOGLE_PLAY_MUSIC'";
    	
    	Cursor cursor = getDatabase().query(MUSIC_LIBRARY_TABLE, columns, where, null, null, null, null);
    	String localCopyPath = null;
    	if (cursor!=null) {
    		if (cursor.getCount() > 0) {
    			cursor.moveToFirst();
    			localCopyPath = cursor.getString(cursor.getColumnIndex(LOCAL_COPY_PATH));
    			
    		}
    		
    	}
    	
    	return localCopyPath;
    			 
    }

