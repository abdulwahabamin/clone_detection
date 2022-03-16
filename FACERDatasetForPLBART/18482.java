    /**
     * Returns a list of all the songs by an album artist.
     */
    public Cursor getAllSongsByAlbumArtist(String selection) {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " WHERE " +
        					 BLACKLIST_STATUS + "=" + "'0'" + selection +
        					 " ORDER BY " + SONG_TRACK_NUMBER + "*1 ASC";
        
        return getDatabase().rawQuery(selectQuery, null);
        
    }

