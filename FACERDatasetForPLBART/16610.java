    @Override
    public void onDestroy() {
        FireLog.d(TAG, "(++) onDestroy");
        // Service is being killed, so make sure we release our resources
        playbackManager.handleStopRequest(null);
        mediaNotificationManager.stopNotification();

        delayedStopHandler.removeCallbacksAndMessages(null);
        session.release();
    }

