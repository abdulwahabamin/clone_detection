    public boolean pausePlayback() {

        try {
            isPlay=false;
            getCurrentMediaPlayer().pause();

            updateNotification();
            UpdateMetadata();

            if(UtilFunctions.currentVersionSupportLockScreenControls()){
                remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_PAUSED);
            }

            mHandler.postDelayed(changeButton, 100);
            //updateWidgets();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

