   /**
    * Returns a cursor with unique albums by an artist.
    */
    public Cursor getAllUniqueAlbumsByArtist(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
    								 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + SONGS_COUNT +
    								 ", " + SONG_YEAR + ", " + SONG_SOURCE + ", " + SONG_DURATION + ", " +
    								 LOCAL_COPY_PATH + ", " + SONG_ALBUM_ART_PATH + ", " + SONG_TITLE +
    	    						 ", " + SONG_ALBUM + ", " + SONG_GENRE + " FROM " + 
    								 MUSIC_LIBRARY_TABLE +" WHERE " + BLACKLIST_STATUS + "=" + "'" + 
    								 "0" + "'" + selection + " GROUP BY " + 
    								 SONG_ALBUM + " ORDER BY " + SONG_YEAR
    								 + "*1 ASC";
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

