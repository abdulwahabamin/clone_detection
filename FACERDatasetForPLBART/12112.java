    /**
     * {@hide}
     */
    void reset() {
        // Discard current keys
        sResetInProgress = true;
        sDeleteInProgress = false;
        sOldUnlockKey = null;
        sUnlockKey = null;
    }

