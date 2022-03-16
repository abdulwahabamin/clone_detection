    public boolean skipToNextTrack() {
        try {
            int lastSong=PlayerConstants.SONG_NUMBER;
            final boolean lastisPlay=isPlay;
            isPlay=true;

            incrementCurrentSongIndex();

            getMediaPlayer().reset();
            getMediaPlayer2().reset();
            clearCrossfadeCallbacks();

            getHandler().removeCallbacks(crossFadeRunnable);
            getMediaPlayer().setVolume(1.0f, 1.0f);
            getMediaPlayer2().setVolume(1.0f, 1.0f);

            mFirstRun = true;
            prepareMediaPlayer(PlayerConstants.SONG_NUMBER);
            MainActivity.setSongPlay(lastSong, PlayerConstants.SONG_NUMBER);
            updateNotification();
            UpdateMetadata();

            if (!lastisPlay)
            {
                mHandler.postDelayed(changeButton,100);
            }

            mHandler.postDelayed(updateUI, 200);
            mHandler.postDelayed(updateImage, 200);

            if(UtilFunctions.currentVersionSupportLockScreenControls()){
                remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_PLAYING);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

