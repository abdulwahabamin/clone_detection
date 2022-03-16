    private void startMediaPlayer2() throws IllegalStateException {
        isPlay=true;
        setCurrentMediaPlayer(2);
        getMediaPlayer2().start();

        updateNotification();
        int nextsong=PlayerConstants.SONG_NUMBER+1;
        prepareMediaPlayer(nextsong);
    }

