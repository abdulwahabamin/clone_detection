    public void handleStopRequest() {
        Log.d(TAG, "handleStopRequest:");
        Log.i(TAG, "handleStopRequest:mState=" + Playback.states[mPlayback.getState()]);

        if (mPlayback.stop()) {
            mServiceCallback.onPlaybackStop();
        }
    }

