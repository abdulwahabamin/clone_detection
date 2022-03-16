    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.d(TAG, "onCompletion():called");
        // set state to paused
        mState = Playback.CUSTOM_PLAYBACK_STATE_PAUSED;
        // seek player to zero to reset seekbar on ui
        mMediaPlayer.seekTo(0);
        // set resume position zero if the ui plays
        mResumePosition = 0;
        // tell playback manager that playback has completed
        mCallback.onCompletion();
    }

