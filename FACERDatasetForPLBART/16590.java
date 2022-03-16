    private void giveUpAudioFocus() {
        FireLog.d(TAG, "(++) giveUpAudioFocus");
        if (audioManager.abandonAudioFocus(onAudioFocusChangeListener)
                == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            currentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK;
        }
    }

