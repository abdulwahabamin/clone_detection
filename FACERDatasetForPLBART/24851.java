    public boolean stopServiceManually(){
        try {
            isPlay=false;
            if(UtilFunctions.currentVersionSupportLockScreenControls()){
                remoteControlClient.setPlaybackState(RemoteControlClient.PLAYSTATE_STOPPED);
            }

            saveLastPosition();
            MainActivity.changeButton();

            mService.stopSelf();
        }
        catch (Exception e){}
        return true;
    }

