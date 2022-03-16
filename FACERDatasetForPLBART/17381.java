    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy:called");
        // Service is being killed, so make sure we release our resources
        mPlaybackManager.handleStopRequest();
        mMediaSession.release();
        mMediaNotificationManager.stopNotification();
    }

