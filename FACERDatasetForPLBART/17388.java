    @Override
    public void onPlaybackStop() {
        Log.d(TAG, "onPlaybackStop:called");
        mMediaSession.setActive(false);
        // stop foreground so that the notification can be dismissed
        stopForeground(false);
    }

