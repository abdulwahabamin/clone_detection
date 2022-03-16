    public boolean skipToTrack(int trackIndex) {
        try {
            boolean lastisPlay=isPlay;
            isPlay=true;
            getMediaPlayer().reset();
            getMediaPlayer2().reset();
            clearCrossfadeCallbacks();

            getHandler().removeCallbacks(crossFadeRunnable);
            getMediaPlayer().setVolume(1.0f, 1.0f);
            getMediaPlayer2().setVolume(1.0f, 1.0f);


            mFirstRun = true;
            prepareMediaPlayer(trackIndex);
            UpdateMetadata();
            if (!lastisPlay)
            {

                mHandler.postDelayed(changeButton, 100);
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

