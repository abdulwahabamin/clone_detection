    @Override
    public void start() {
        Log.d(TAG, "start() Entry.");
        musicSrv.go();
        startSeekTracking();
    }

