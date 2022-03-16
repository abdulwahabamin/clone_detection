    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() entry.");
        paused = true;
        stopSeekTracking();
    }

