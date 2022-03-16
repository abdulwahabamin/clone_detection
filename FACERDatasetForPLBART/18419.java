    /**
     * Retrieves a HashSet of all the song ids within a particular music library.
     */
    public HashSet<String> getAllSongIdsInLibrary(String libraryName, String tag) {
    	HashSet<String> songIdsHashSet = new HashSet<String>();
    	
    	libraryName = libraryName.replace("'", "''");
    	tag = tag.replace("'", "''");
    	
    	String where = LIBRARY_NAME + "=" + "'" + libraryName + "'" + " AND "
    				 + LIBRARY_TAG + "=" + "'" + tag + "'";
    	
    	Cursor cursor = getDatabase().query(LIBRARIES_TABLE, null, where, null, null, null, SONG_ID);
    	if (cursor.getCount() > 0) {
    		for (int i=0; i < cursor.getCount(); i++) {
    			cursor.moveToPosition(i);
    			songIdsHashSet.add(cursor.getString(cursor.getColumnIndex(SONG_ID)));
    		}
    		
    	}
    	
    	if (cursor!=null) {
    		cursor.close();
    		cursor = null;
    	}
    	
    	return songIdsHashSet;
    }

