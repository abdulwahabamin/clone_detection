    private boolean playPlayer() {
        Log.d(TAG, "playPlayer():called");
        Log.i(TAG, "playPlayer:state="+Playback.states[mState]);

        // if stopped then we will prepare player from scratch
        if (isStopped()) {
            return preparePlayer();
        } else if (isPaused() || isPlaying()) { // only play if it is paused or playing
            // seek to if the player is resuming from being paused
            if (mResumePosition != 0) {
                mMediaPlayer.seekTo(mResumePosition);
            }
            mMediaPlayer.start();
            mState = Playback.CUSTOM_PLAYBACK_STATE_PLAYING;
            return true;
        }
        return false;
    }

