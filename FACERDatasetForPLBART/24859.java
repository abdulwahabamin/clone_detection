    public int decrementCurrentSongIndex() {
        if ((PlayerConstants.SONG_NUMBER-1) > -1)
            PlayerConstants.SONG_NUMBER--;

        return PlayerConstants.SONG_NUMBER;
    }

