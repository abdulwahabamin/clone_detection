    /**
     * Sets the flags for the media transport control buttons that this client supports.
     * @param transportControlFlags
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_PREVIOUS},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_REWIND},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_PLAY},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_PAUSE},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_STOP},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_FAST_FORWARD},
     *      {@link android.media.RemoteControlClient#FLAG_KEY_MEDIA_NEXT}
     */
    public void setTransportControlFlags(int transportControlFlags) {
        if (sHasRemoteControlAPIs) {
            try {
                sRCCSetTransportControlFlags.invoke(mActualRemoteControlClient,
                        transportControlFlags);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

