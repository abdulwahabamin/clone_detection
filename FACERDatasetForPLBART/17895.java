    @Override
    public void onSeekbarStopTrackingTouch(int progress) {
        Log.d(TAG, "onSeekbarStopTrackingTouch:called progress="+progress);
        mMediaBrowserManager.getMediaController()
                .getTransportControls().seekTo(progress);
    }

