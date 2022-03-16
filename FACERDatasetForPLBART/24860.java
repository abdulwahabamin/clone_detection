    private int determineNextSongIndex() {
        if (isAtEndOfQueue())
            return -1;
        else
            return (PlayerConstants.SONG_NUMBER + 1);
    }

