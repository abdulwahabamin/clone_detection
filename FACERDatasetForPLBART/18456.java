    /**
     * Deletes all songs whose "scanned" flag is false.
     */
    public void deleteAllUnscannedSongs() {
        String selection = SONG_SCANNED + "=" + "'FALSE'";
        getDatabase().delete(MUSIC_LIBRARY_TABLE, selection, null);
        
    }

