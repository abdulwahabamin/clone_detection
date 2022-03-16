    /**
     * Deletes all Google Play Music entries in the table.
     */
    public void deleteAllGooglePlayMusicSongs() {
    	String where = SONG_SOURCE + "=" + "'GOOGLE_PLAY_MUSIC'";
    	getDatabase().delete(MUSIC_LIBRARY_TABLE, where, null);
    }

