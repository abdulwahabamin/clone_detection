    /**
     * Returns a cursor with unique albums in the specified genre, within the specified library.
     */
    public Cursor getAllUniqueAlbumsInGenreInLibrary(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + 
									 MUSIC_LIBRARY_TABLE + "." + _ID + ", " + SONG_FILE_PATH + ", " + SONG_ALBUM_ARTIST + ", "
									 + SONG_SOURCE + ", " + SONG_DURATION + ", " + SONG_ALBUM_ART_PATH + ", " + SONG_ARTIST 
									 + ", " + SONG_GENRE + ", " + SONG_YEAR + ", " + SONGS_COUNT + ", " + LOCAL_COPY_PATH + " FROM " + MUSIC_LIBRARY_TABLE
									 + " INNER JOIN " + LIBRARIES_TABLE + " ON (" 
									 + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + LIBRARIES_TABLE + "." 
									 + SONG_ID + ") WHERE " + MUSIC_LIBRARY_TABLE + "." + 
									 BLACKLIST_STATUS + "=" + "'" + "0" + "'" + selection + " GROUP BY " + 
									 MUSIC_LIBRARY_TABLE + "." + SONG_ALBUM + " ORDER BY " + MUSIC_LIBRARY_TABLE + "." + SONG_ALBUM
									 + " ASC";

    	return getDatabase().rawQuery(selectDistinctQuery, null);
    	
    }

