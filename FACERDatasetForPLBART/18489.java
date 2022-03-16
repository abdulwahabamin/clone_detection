    /**
     * Returns a cursor with unique albums by an artist within the specified library.
     */
    public Cursor getAllUniqueAlbumsByArtistInLibrary(String selection) {
    	String selectDistinctQuery = "SELECT DISTINCT(" + SONG_ALBUM + "), " + MUSIC_LIBRARY_TABLE + "." +
									 _ID + ", " + SONG_ARTIST + ", " + SONG_FILE_PATH + ", " + LOCAL_COPY_PATH +
									 ", " + SONG_YEAR + ", " + SONG_SOURCE + ", " + SONG_DURATION + ", " + SONGS_COUNT + ", " +
									 SONG_ALBUM_ART_PATH + ", " + SONG_TITLE + ", " + SONG_ALBUM + ", " + SONG_GENRE + " FROM " + 
									 MUSIC_LIBRARY_TABLE + " INNER JOIN " + LIBRARIES_TABLE + " ON (" 
									 + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + LIBRARIES_TABLE + "." 
									 + SONG_ID + ") WHERE " + BLACKLIST_STATUS + "=" + "'" + 
									 "0" + "'" + selection + " GROUP BY " + SONG_ALBUM + " ORDER BY " + SONG_YEAR
									 + "*1 ASC";
    	
    	return getDatabase().rawQuery(selectDistinctQuery, null);
    }

