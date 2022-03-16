    /**
     * Changes the current sort order, building the appropriate query string
     * for the selected order.
     */
    boolean setSortMode(int sortMode) {
        if (sortMode != mSortMode) {
            switch (sortMode) {
                case TRACK_MENU:
                    mSortMode = sortMode;
                    mSortOrder = MediaStore.Audio.Media.TITLE_KEY;
                    doQuery(false, null);
                    return true;
                case ALBUM_MENU:
                    mSortMode = sortMode;
                    mSortOrder = MediaStore.Audio.Media.ALBUM_KEY + " ASC, "
                            + MediaStore.Audio.Media.TRACK + " ASC, "
                            + MediaStore.Audio.Media.TITLE_KEY + " ASC";
                    doQuery(false, null);
                    return true;
                case ARTIST_MENU:
                    mSortMode = sortMode;
                    mSortOrder = MediaStore.Audio.Media.ARTIST_KEY + " ASC, "
                            + MediaStore.Audio.Media.ALBUM_KEY + " ASC, "
                            + MediaStore.Audio.Media.TRACK + " ASC, "
                            + MediaStore.Audio.Media.TITLE_KEY + " ASC";
                    doQuery(false, null);
                    return true;
            }
            
        }
        return false;
    }

