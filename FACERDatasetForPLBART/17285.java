    public void handlePauseRequest() {
        Log.d(TAG, "handlePauseRequest:called");
        Log.i(TAG, "handlePauseRequest:mState=" + Playback.states[mPlayback.getState()]);
        if (mPlayback.pause()) {
            mServiceCallback.onPlaybackStop();
        }
    }

