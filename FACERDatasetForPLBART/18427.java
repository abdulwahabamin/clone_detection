    /**
     * Returns a selection cursor of all unique artists in the 
     * specified library. The library should be specified in the 
     * selection parameter.
     */
    public Cursor getAllUniqueArtistsInLibrary(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ARTIST + "), " 
    								 + MUSIC_LIBRARY_TABLE + "." + _ID + ", " 
    								 + SONG_FILE_PATH + ", " + ARTIST_ART_LOCATION + ", "
    								 + SONG_SOURCE + ", " + ALBUMS_COUNT + ", " + SONG_DURATION + ", "
    								 + SONG_ALBUM_ART_PATH + " FROM " + MUSIC_LIBRARY_TABLE 
    								 + " INNER JOIN " + DBAccessHelper.LIBRARY_NAME 
    								 + " ON (" + MUSIC_LIBRARY_TABLE + "." + _ID + "=" 
    								 + DBAccessHelper.LIBRARY_NAME + "." 
    								 + DBAccessHelper.SONG_ID + ") WHERE " 
    								 + MUSIC_LIBRARY_TABLE + "." + BLACKLIST_STATUS + "=" 
    								 + "'" + "0" + "'" + selection + " GROUP BY " 
    								 + MUSIC_LIBRARY_TABLE + "." + SONG_ARTIST + " ORDER BY " 
    								 + MUSIC_LIBRARY_TABLE + "." + SONG_ARTIST
    								 + " ASC" ;
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

