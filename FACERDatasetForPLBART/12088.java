    /**
     * Request a synchronization of the underlying filesystem
     *
     * @param program The last called program
     */
    private void requestSync(Program program) {
        if (program.requiresSync()) {
            mRequiresSync = true;
        }

        // There is some changes to synchronize?
        if (mRequiresSync) {
            Boolean defaultValue = ((Boolean)FileManagerSettings.
                    SETTINGS_SECURE_STORAGE_DELAYED_SYNC.getDefaultValue());
            Boolean delayedSync =
                    Boolean.valueOf(
                            Preferences.getSharedPreferences().getBoolean(
                                FileManagerSettings.SETTINGS_SECURE_STORAGE_DELAYED_SYNC.getId(),
                                defaultValue.booleanValue()));
            mSyncHandler.removeMessages(MSG_SYNC_FS);
            if (delayedSync) {
                // Request a sync in 30 seconds, if users is not doing any operation
                mSyncHandler.sendEmptyMessageDelayed(MSG_SYNC_FS, SYNC_WAIT);
            } else {
                // Do the synchronization now
                mSyncHandler.sendEmptyMessage(MSG_SYNC_FS);
            }
        }
    }

