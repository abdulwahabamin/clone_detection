    /**
     * Checks if equalizer settings already exist for the given song.
     */
    public boolean hasEqualizerSettings(String songId) {
    	
    	String where = SONG_ID + "=" + "'" + songId + "'";
    	Cursor cursor = getDatabase().query(EQUALIZER_TABLE, 
    							 new String[] { SONG_ID }, 
    							 where, 
    							 null, 
    							 null, 
    							 null, 
    							 null);
    	
    	if (cursor!=null) {
    		if (cursor.getCount() > 0) {
    			cursor.close();
    			return true;
    		} else {
    			cursor.close();
    			return false;
    		}
    		
    	} else {
    		return false;
    	}
    	
    }

