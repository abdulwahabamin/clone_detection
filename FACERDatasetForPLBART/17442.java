    private void resetPlayer() {
        Log.d(TAG, "resetPlayer():called");
        Log.i(TAG, "resetPlayer:state="+Playback.states[mState]);
        mMediaPlayer.reset();

        mState = Playback.CUSTOM_PLAYBACK_STATE_IDLE;
    }

