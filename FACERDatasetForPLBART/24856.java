    private void IflastSong(){
        try {
            isPlay=false;
            if(UtilFunctions.currentVersionSupportLockScreenControls()){
                remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_STOPPED);
            }

            getMediaPlayer().reset();
            getMediaPlayer2().reset();

            PlayerConstants.SONG_NUMBER=0;

            mHandler.post(updateImage);
            mHandler.post(changeButton);
            mHandler.post(updateUI);

        }
        catch (Exception e){}
    }

