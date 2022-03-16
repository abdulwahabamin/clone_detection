    @Override
    public void onPlaybackStateUpdated(PlaybackStateCompat newState) {
        Log.d(TAG, "onPlaybackStateUpdated:state="+newState);
        mMediaSession.setPlaybackState(newState);

    }

