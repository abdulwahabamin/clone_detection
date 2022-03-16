    /**
     * Returns a cursor of all the songs in an album by a specific artist, within the specified library.
     */
    public Cursor getAllSongsInAlbumByAlbumArtistInLibrary(String selection) {

        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " INNER JOIN " + DBAccessHelper.LIBRARY_NAME + " ON (" 
				 		   + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + DBAccessHelper.LIBRARY_NAME + "." 
				 		   + DBAccessHelper.SONG_ID + ") WHERE " +
				 		   BLACKLIST_STATUS + "=" + "'0'" + selection +
				 		   " ORDER BY " + SONG_TRACK_NUMBER + "*1 ASC";
     
        return getDatabase().rawQuery(selectQuery, null);
        
    }

