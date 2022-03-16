    /** 
     * Returns a cursor of all songs in an album. The album 
     * should be passed in via the selection parameter.
     */
    public Cursor getSongsInAlbum(String selection, String[] projection) {
        return getDatabase().query(MUSIC_LIBRARY_TABLE, projection, selection, null, null, null, SONG_YEAR);
    }

