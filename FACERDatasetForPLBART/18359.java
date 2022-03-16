    /**
     * Determines the next activity's fragment id based on the
     * current activity's fragment id.
     */
    private int getNewFragmentId() {
        switch (mFragmentId) {
            case Common.ARTISTS_FLIPPED_FRAGMENT:
                return Common.ARTISTS_FLIPPED_SONGS_FRAGMENT;
            case Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT:
                return Common.ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT;
            case Common.GENRES_FLIPPED_FRAGMENT:
                return Common.GENRES_FLIPPED_SONGS_FRAGMENT;
            default:
                return -1;
        }

    }

