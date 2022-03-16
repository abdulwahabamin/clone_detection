    private synchronized void resetToInitialState() {
        if (currentTrackPlayer != null) {
            currentTrackPlayer.release();
            currentTrackPlayer = null;
        }
        if (onDeckTrackPlayer != null) {
            onDeckTrackPlayer.release();
            onDeckTrackPlayer = null;
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
    }

