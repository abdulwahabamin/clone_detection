    public synchronized void pausePlayer() {
        Log.d(TAG, "pausePlayer() entry.");
        if (currentTrackPlayer != null) {
            currentTrackPlayer.pause();
            tellTheWorld(SERVICE_PAUSED);
        }
        try {
            if (noisyReceiverRegistered)
                unregisterReceiver(myNoisyAudioStreamReceiver);
            noisyReceiverRegistered = false;
        } catch (Exception e) {
            Log.e("MUSIC SERVICE", "Error unregistering noisy audio receiver.", e);
        }

        if (haveAudioFocus) {
            am.abandonAudioFocus(afChangeListener);
            haveAudioFocus = false;
        }
        stopForeground(true);
    }

