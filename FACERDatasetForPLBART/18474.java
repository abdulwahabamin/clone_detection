    /**
     * Returns a cursor with all the albums in the specified genre.
     */
    public Cursor getAllUniqueAlbumsInGenre(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
				 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + 
    			 BLACKLIST_STATUS + ", " + SONG_GENRE + ", " + SONG_YEAR + ", " +
				 SONG_ALBUM_ART_PATH + ", " + SONG_SOURCE + ", " + SONGS_COUNT + ", " +
    			 SONG_ALBUM_ARTIST + ", " + SONG_DURATION + ", " + LOCAL_COPY_PATH
				 + " FROM " + MUSIC_LIBRARY_TABLE + " WHERE " + 
				 BLACKLIST_STATUS + "=" + "'" + 
				 "0" + "'" + selection + " GROUP BY " + 
				 SONG_ALBUM + " ORDER BY " + SONG_ALBUM
				 + " ASC";

    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

