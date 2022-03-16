    @Override
    public void pause() {
        Log.d(TAG, "start() Entry.");
        musicSrv.pausePlayer();
        stopSeekTracking();
    }

