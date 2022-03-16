    private boolean configurePlayerState() {
        Log.d(TAG, "configurePlayerState:called");
        Log.i(TAG,"mCurrentAudioFocusState="+focusStates[mCurrentAudioFocusState]);
        Log.i(TAG, "configurePlayerState:state="+Playback.states[mState]);

        boolean isPlaying = false;

        if (mCurrentAudioFocusState == AUDIO_NO_FOCUS_NO_DUCK) {
            // We don't have audio focus and can't duck, so we have to pause
            if (pausePlayer()) {
                // tell playback manager about state change
                mCallback.onPlaybackStatusChanged(mState);
                mCallback.onError("cannot gain audio focus");
            }
        } else {
            registerAudioNoisyReceiver();

            if (mCurrentAudioFocusState == AUDIO_NO_FOCUS_CAN_DUCK) {
                // We're permitted to play, but only if we 'duck', ie: play softly
                mMediaPlayer.setVolume(VOLUME_DUCK, VOLUME_DUCK);
            } else {
                mMediaPlayer.setVolume(VOLUME_NORMAL, VOLUME_NORMAL);
            }

            // If we were playing when we lost focus, we need to resume playing.
            if (mPlayOnFocusGain) {
                if (playPlayer()) {
                    isPlaying = true;
                    // tell playback manager about state change
                    mCallback.onPlaybackStatusChanged(mState);
                }
                // set the flag to false to handle any unexpected behaviors
                mPlayOnFocusGain = false;
            }
        }

        return isPlaying;
    }

