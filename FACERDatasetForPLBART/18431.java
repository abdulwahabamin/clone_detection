    /**
     * Returns a cursor with all unique albums by an album artist.
     */
    public Cursor getAllUniqueAlbumsByAlbumArtist(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
    								 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + SONG_ALBUM_ARTIST +
    								 ", " + SONG_YEAR + ", " + SONG_SOURCE + ", " + SONG_DURATION + ", " + SONG_ID + ", " +
    								 LOCAL_COPY_PATH + ", " + SONG_ALBUM_ART_PATH + ", " + SONG_TITLE +
    	    						 ", " + SONG_ALBUM + ", " + SONG_GENRE + ", " + SONGS_COUNT + " FROM " +
    								 MUSIC_LIBRARY_TABLE +" WHERE " + BLACKLIST_STATUS + "=" + "'" + 
    								 "0" + "'" + selection + " GROUP BY " + 
    								 SONG_ALBUM + " ORDER BY " + SONG_YEAR
    								 + "*1 ASC";
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

