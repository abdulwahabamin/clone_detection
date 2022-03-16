    public void batchUpdateSongBlacklist(HashMap<String, Boolean> songIdBlacklistStatusPair) {
    	
    	//Retrieve the list of all keys (songIds) within the HashMap.
    	String[] songIdsArray = new String[songIdBlacklistStatusPair.size()];
    	songIdBlacklistStatusPair.keySet().toArray(songIdsArray);
    	
    	for (int i=0; i < songIdsArray.length; i++) {
    		String songId = songIdsArray[i];
    		boolean blacklistStatus = songIdBlacklistStatusPair.get(songId);
    		
    		ContentValues values = new ContentValues();
    		values.put(BLACKLIST_STATUS, blacklistStatus);
    		
    		String where = _ID + "=" + "'" + songId + "'";
    		getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    		
    	}

    }

