    @Override
    public boolean onUnbind(Intent intent) {
        if (!mPlaybackManager.isPlaying()) {
            // stop the service if the ui unbinds and the player is not playing
            stopSelf();
        }
        return super.onUnbind(intent);
    }

