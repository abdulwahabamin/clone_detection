    private boolean pausePlayer() {
        Log.d(TAG, "pausePlayer():called");
        Log.i(TAG, "pausePlayer:state="+Playback.states[mState]);

        // already paused?
        if (isPaused()) {
            return true;
        }

        // if playing then only we can pause
        if (isPlaying()) {
            mResumePosition = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
            mState = Playback.CUSTOM_PLAYBACK_STATE_PAUSED;
            return true;
        }

        return false;
    }

