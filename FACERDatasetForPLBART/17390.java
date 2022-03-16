    @Override
    public void onShuffleModeChanged(int mode) {
        Log.d(TAG, "onShuffleModeChanged:mode="+mode);
        if (mode == 0) {
            mMediaSession.setShuffleModeEnabled(false);
        } else if (mode == 1) {
            mMediaSession.setShuffleModeEnabled(true);
        }
    }

