    /**
     * Returns a selection cursor of all unique album artists in the 
     * specified library. The library should be specified in the 
     * selection parameter.
     */
    public Cursor getAllUniqueAlbumArtistsInLibrary(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM_ARTIST + "), " 
    								 + MUSIC_LIBRARY_TABLE + "." + _ID + ", " 
    								 + SONG_FILE_PATH + ", " + ARTIST_ART_LOCATION + ", "
    								 + SONG_SOURCE + ", " + SONG_DURATION + ", " + ALBUMS_COUNT + ", "
    								 + SONG_ALBUM_ART_PATH + " FROM " + MUSIC_LIBRARY_TABLE 
    								 + " INNER JOIN " + DBAccessHelper.LIBRARY_NAME + " ON (" 
    								 + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + DBAccessHelper.LIBRARY_NAME + "." 
    								 + DBAccessHelper.SONG_ID + ") WHERE " 
    								 + MUSIC_LIBRARY_TABLE + "." + BLACKLIST_STATUS + "=" + "'" 
    								 + "0" + "'" + selection + " GROUP BY " + MUSIC_LIBRARY_TABLE 
    								 + "." + SONG_ALBUM_ARTIST + " ORDER BY " + MUSIC_LIBRARY_TABLE 
    								 + "." + SONG_ALBUM_ARTIST
    								 + " ASC" ;
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

