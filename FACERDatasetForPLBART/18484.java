    /**
     * Returns a HashMap of all the songIds and their blacklist status.
     */
    public HashMap<String, Boolean> getAllSongIdsBlacklistStatus() {
    	HashMap<String, Boolean> songIdBlacklistStatusPair = new HashMap<String, Boolean>();
    	
    	String[] columns = { _ID, BLACKLIST_STATUS };
    	Cursor cursor = getDatabase().query(MUSIC_LIBRARY_TABLE, columns, null, null, null, null, null);

        if (cursor==null)
            return null;

    	if (cursor.getCount() > 0) {
    		for (int i=0; i < cursor.getCount(); i++) {
    			cursor.moveToPosition(i);
    			String songId = cursor.getString(cursor.getColumnIndex(_ID));
    			boolean blacklistStatus = cursor.getString(cursor.getColumnIndex(BLACKLIST_STATUS)).equals("true");
    			songIdBlacklistStatusPair.put(songId, blacklistStatus);
    		}
    		
    	}
    	

    	cursor.close();
    	return songIdBlacklistStatusPair;
    }

