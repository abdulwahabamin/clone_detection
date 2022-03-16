    /**
     * Helper method for getPlaybackCursor(). Returns the correct
     * cursor retrieval method for the specified playback/fragment
     * route in the specified library.
     */
    private Cursor getPlaybackCursorInLibraryHelper(String querySelection, int fragmentId) {
        switch (fragmentId) {
            case Common.PLAY_ALL_BY_ARTIST:
            case Common.PLAY_ALL_BY_ALBUM_ARTIST:
            case Common.PLAY_ALL_BY_ALBUM:
            case Common.PLAY_ALL_IN_GENRE:
            case Common.PLAY_ALL_IN_FOLDER:
                querySelection += " ORDER BY " + MUSIC_LIBRARY_TABLE + "." + SONG_TRACK_NUMBER + "*1 ASC";
                break;
            case Common.PLAY_ALL_SONGS:
                querySelection += " ORDER BY " + MUSIC_LIBRARY_TABLE + "." + SONG_TITLE + " ASC";
                break;
            case Common.PLAY_ALL_IN_PLAYLIST:
                //TODO Must order the cursor by the order of the playlist's track arrangement.
        }
        return getAllSongsInLibrarySearchable(querySelection);
    }

