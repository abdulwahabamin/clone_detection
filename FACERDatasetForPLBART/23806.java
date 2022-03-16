    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() entry.");
        if (musicSrv != null && musicSrv.hasTrack()) {
            if (paused) {
                paused = false;
                updateControls();
                if (isPlaying())
                    startSeekTracking();
            }
        }
    }

