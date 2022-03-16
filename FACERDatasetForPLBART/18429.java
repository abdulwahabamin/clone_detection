    /**
     * Returns a selection cursor of all unique album artists.
     */
    public Cursor getAllUniqueAlbumArtists(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM_ARTIST + "), " 
    								 + _ID + ", " + SONG_FILE_PATH + ", " + ARTIST_ART_LOCATION 
    								 + ", " + BLACKLIST_STATUS + ", " + ALBUMS_COUNT + ", " + SONG_SOURCE + ", "
    								 + SONG_ALBUM_ART_PATH + ", " + SONG_DURATION + " FROM " 
    								 + MUSIC_LIBRARY_TABLE + " WHERE " + BLACKLIST_STATUS 
    								 + "=" + "'" + "0" + "'" + selection + " GROUP BY " 
    								 + SONG_ALBUM_ARTIST + " ORDER BY " + SONG_ALBUM_ARTIST
    								 + " ASC";
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

