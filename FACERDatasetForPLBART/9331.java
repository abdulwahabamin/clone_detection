    /**
     * {@hide}
     */
    void umount() {
        // Discard current keys
        sResetInProgress = false;
        sDeleteInProgress = false;
        sOldUnlockKey = null;
        sUnlockKey = null;
    }

