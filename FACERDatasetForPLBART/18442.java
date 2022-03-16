    /**
     * Returns a cursor of all the songs in an album by a specific artist.
     */
    public Cursor getAllSongsInAlbumByArtist(String selection) {
        String selectQuery = "SELECT  * FROM " +  MUSIC_LIBRARY_TABLE + " WHERE " +
        					 BLACKLIST_STATUS + "=" + "'0'" + selection +
        					 " ORDER BY " + SONG_TRACK_NUMBER + "*1 ASC";
        
        return getDatabase().rawQuery(selectQuery, null);
    }

