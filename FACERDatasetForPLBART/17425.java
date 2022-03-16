    @Override
    public synchronized boolean pause() {
        Log.d(TAG, "pause():called");
        Log.i(TAG, "pause:state="+Playback.states[mState]);

        // if preparing we can't do anything
        if (isPreparing()) {
            Log.w(TAG, "pause:player is preparing");
            return false;
        }

        if (pausePlayer()) {
            Log.i(TAG, "pause():paused successfully");
            // we don't want to listen to headphone plug/unplug while paused
            unregisterAudioNoisyReceiver();
            // tell playback manager for the state change
            mCallback.onPlaybackStatusChanged(mState);
            return true;
        }
        return false;
    }

