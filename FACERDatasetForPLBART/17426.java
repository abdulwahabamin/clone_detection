    @Override
    public synchronized boolean stop() {
        Log.d(TAG, "stop():called");
        Log.i(TAG, "stop:state="+Playback.states[mState]);

        // if preparing we can't do anything
        if (isPreparing()) {
            Log.w(TAG, "stop:player is preparing");
            return false;
        }

        if (stopPlayer()) {
            Log.i(TAG, "stop:stopped successfully");
            // we don't want audio focus when the player stops
            giveUpAudioFocus();
            // we don't want to listen to headphone plug/unplug when player stops
            unregisterAudioNoisyReceiver();
            // tell playback manager about state change
            mCallback.onPlaybackStatusChanged(mState);
            return true;
        }
        return false;
    }

