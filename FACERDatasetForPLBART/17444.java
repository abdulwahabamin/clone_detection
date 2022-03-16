    private boolean preparePlayer() {
        Log.d(TAG, "preparePlayer():called");
        Log.i(TAG, "preparePlayer:state="+Playback.states[mState]);
        // if stopped then only we can prepare player
        if (!isStopped()) {
            return false;
        }

        mState = Playback.CUSTOM_PLAYBACK_STATE_PREPARING;
        mMediaPlayer.prepareAsync();

        return true;
    }

