    /**
     * Sets the rating for the specified song.
     */
    public void setSongRating(String songId, int rating) {
    	String where = SONG_ID + "=" + "'" + songId + "'";
    	ContentValues values = new ContentValues();
    	values.put(SONG_RATING, rating);
    	getDatabase().update(MUSIC_LIBRARY_TABLE, values, where, null);
    	
    }

