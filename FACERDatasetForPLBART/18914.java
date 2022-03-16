    /**
     * Determines the next activity's fragment id based on the
     * current activity's fragment id.
     */
    private int getNewFragmentId() {
        switch (mFragmentId) {
            case Common.ARTISTS_FRAGMENT:
                return Common.ARTISTS_FLIPPED_FRAGMENT;
            case Common.ALBUM_ARTISTS_FRAGMENT:
                return Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT;
            case Common.ALBUMS_FRAGMENT:
                return Common.ALBUMS_FLIPPED_FRAGMENT;
            case Common.GENRES_FRAGMENT:
                return Common.GENRES_FLIPPED_FRAGMENT;
            default:
                return -1;
        }

    }

