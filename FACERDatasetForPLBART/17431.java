    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(TAG, "onPrepared:called");
        // set state to paused if player cannot play
        mState = Playback.CUSTOM_PLAYBACK_STATE_PAUSED;
        // set resume position zero because new song is being played
        mResumePosition = 0;
        configurePlayerState();
    }

