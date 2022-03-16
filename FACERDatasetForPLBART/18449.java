    /**
     * Returns a list of all the songs in an album by an album artist, within the specified library.
     */
    public Cursor getAllSongsByAlbumArtistInLibrary(String selection) {

        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " INNER JOIN " + DBAccessHelper.LIBRARY_NAME + " ON (" 
				 		   + MUSIC_LIBRARY_TABLE + "." + _ID + "=" + DBAccessHelper.LIBRARY_NAME + "." 
				 		   + DBAccessHelper.SONG_ID + ") WHERE " +
				 		   BLACKLIST_STATUS + "=" + "'0'" + selection +
				 		   " ORDER BY " + SONG_ALBUM + " ASC, " + SONG_TRACK_NUMBER + "*1 ASC";
     
        return getDatabase().rawQuery(selectQuery, null);
    }

