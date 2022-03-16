    public int incrementCurrentSongIndex() {
        if ((PlayerConstants.SONG_NUMBER+1) < PlayerConstants.SONGS_LIST.size())
            PlayerConstants.SONG_NUMBER++;

        return PlayerConstants.SONG_NUMBER;
    }

