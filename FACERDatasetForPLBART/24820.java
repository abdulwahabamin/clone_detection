    private void startMediaPlayer() throws IllegalStateException {
        isPlay=true;
        setCurrentMediaPlayer(1);
        getMediaPlayer().start();

        if (!mFirstRun == false) {
            if (mHandler != null) {
                mHandler.post(startCrossFadeRunnable);
            }
        }

        updateNotification();
//        setCurrentSong(getCurrentSong());
        int nextsong=PlayerConstants.SONG_NUMBER+1;

        prepareMediaPlayer2(nextsong);

    }

