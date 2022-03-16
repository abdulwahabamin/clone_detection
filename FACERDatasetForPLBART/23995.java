    /**
     * Called when we receive a ACTION_MEDIA_EJECT notification.
     */
    private void closeExternalStorageFiles() {
        // stop playback and clean up if the SD card is going to be unmounted.
        stop();
        if (mSession != null) {
            deactivateMediaSession();
        }
        gotoIdleState();
        notifyChange(QUEUE_CHANGED);
        notifyChange(META_CHANGED);
    }

