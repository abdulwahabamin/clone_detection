    public boolean startPlayback() {

        try {
            isPlay=true;
            if (checkAndRequestAudioFocus()) {
                getCurrentMediaPlayer().start();
                updateNotification();
                UpdateMetadata();
                //updateWidgets();
            } else {
                return false;
            }

            if(UtilFunctions.currentVersionSupportLockScreenControls()){
                remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_PLAYING);
            }

            mHandler.postDelayed(changeButton, 100);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

