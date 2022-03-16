    @Override
    public synchronized boolean play() {
        Log.d(TAG, "play(no):called");
        Log.i(TAG, "play(no):state="+Playback.states[mState]);

        // if preparing we can't do anything
        if (isPreparing()) {
            Log.w(TAG, "play(no):player is preparing");
            return false;
        }

        // set flag to true to start playing when configurePlayerState is called
        mPlayOnFocusGain = true;
        // try to get audio focus
        tryToGetAudioFocus();
        // register audio noisy receiver for headphone plug/unplug
        registerAudioNoisyReceiver();

        return configurePlayerState();
    }

