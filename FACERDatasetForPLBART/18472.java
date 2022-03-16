    /**
     * Returns the rating for the specified song.
     */
    public int getSongRating(String songId) {
    	String where = SONG_ID + "=" + "'" + songId + "'";
    	Cursor cursor = getDatabase().query(MUSIC_LIBRARY_TABLE, 
    										    new String[] { _ID, SONG_RATING }, 
    										    where, 
    										    null, 
    										    null, 
    										    null, 
    										    null);
    	
    	int songRating = 0;
    	if (cursor!=null) {
    		songRating = cursor.getInt(cursor.getColumnIndex(SONG_RATING));
    		cursor.close();
    	}
    	
    	return songRating;
    	
    }

