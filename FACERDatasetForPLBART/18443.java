    /**
     * Returns a cursor of all the songs in an album by a specific artist, within the specified library.
     */
    public Cursor getAllSongsInAlbumByArtistInLibrary(String selection) {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " INNER JOIN " + LIBRARIES_TABLE + " ON (" 
				 		   + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + LIBRARIES_TABLE + "." 
				 		   + SONG_ID + ") WHERE " +
				 		   BLACKLIST_STATUS + "=" + "'0'" + selection +
				 		   " ORDER BY " + SONG_TRACK_NUMBER + "*1 ASC";
        
        return getDatabase().rawQuery(selectQuery, null);
     
    }

