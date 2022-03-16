    private Boolean isAtEndOfQueue() {
        if (PlayerConstants.SONGS_LIST.size() == (PlayerConstants.SONG_NUMBER+1)) {
            return true;
        }
        return false;
    }

