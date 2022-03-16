    /**
     * Sets the current playback state.
     * @param state The current playback state, one of the following values:
     *       {@link android.media.RemoteControlClient#PLAYSTATE_STOPPED},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_PAUSED},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_PLAYING},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_FAST_FORWARDING},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_REWINDING},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_SKIPPING_FORWARDS},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_SKIPPING_BACKWARDS},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_BUFFERING},
     *       {@link android.media.RemoteControlClient#PLAYSTATE_ERROR}.
     */
    public void setPlaybackState(int state) {
        if (sHasRemoteControlAPIs) {
            try {
                sRCCSetPlayStateMethod.invoke(mActualRemoteControlClient, state);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

