    public boolean skipToPreviousTrack(Boolean isgetAction) {
        boolean lastisPlay=isPlay;
        isPlay=true;
        try {
            if (getCurrentMediaPlayer().getCurrentPosition() > 8000 && !isgetAction) {
                getCurrentMediaPlayer().seekTo(0);
                return true;
            }

        } catch (Exception e) {
            return false;
        }


        try {

            getMediaPlayer().reset();
            getMediaPlayer2().reset();
            clearCrossfadeCallbacks();

            getHandler().removeCallbacks(crossFadeRunnable);
            getMediaPlayer().setVolume(1.0f, 1.0f);
            getMediaPlayer2().setVolume(1.0f, 1.0f);
            int lastSong=0;
            if (isgetAction && PlayerConstants.lastDuration>8000) {}
            else
            {
                lastSong=PlayerConstants.SONG_NUMBER;
                decrementCurrentSongIndex();
            }

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

