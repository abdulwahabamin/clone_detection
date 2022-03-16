    public synchronized void go() {
        Log.d(TAG, "go() entry.");
        if (currentTrackPlayer != null) {
            deferredGo = false;
            if (!haveAudioFocus) {
                int result = am.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);
                haveAudioFocus = (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED);
            }
            if (haveAudioFocus) {
                registerReceiver(myNoisyAudioStreamReceiver, intentFilter);
                noisyReceiverRegistered = true;
                currentTrackPlayer.start();
                tellTheWorld(SERVICE_NOW_PLAYING);
            }
        } else
            deferredGo = true;
    }

