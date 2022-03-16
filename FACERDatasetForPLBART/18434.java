    /**
     * Returns a selection cursor of all unique albums in the 
     * specified library. The library should be specified in the 
     * selection parameter.
     */
    public Cursor getAllUniqueAlbumsInLibrary(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
									 MUSIC_LIBRARY_TABLE + "." + _ID + ", " + SONG_FILE_PATH + ", " + SONG_ALBUM_ARTIST + ", "
									 + SONG_SOURCE + ", " + SONG_DURATION + ", " + SONG_ALBUM_ART_PATH + ", " + SONG_ARTIST + " FROM " + MUSIC_LIBRARY_TABLE 
									 + " INNER JOIN " + DBAccessHelper.LIBRARY_NAME + " ON (" 
									 + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + DBAccessHelper.LIBRARY_NAME + "." 
									 + DBAccessHelper.SONG_ID + ") WHERE " + MUSIC_LIBRARY_TABLE + "." + 
									 BLACKLIST_STATUS + "=" + "'" + "0" + "'" + selection + " GROUP BY " + 
									 MUSIC_LIBRARY_TABLE + "." + SONG_ALBUM + " ORDER BY " + MUSIC_LIBRARY_TABLE + "." + SONG_ALBUM
									 + " ASC" ;
    			
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    }

