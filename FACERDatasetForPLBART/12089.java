    /**
     * Synchronize the underlying filesystem
     *
     * @retun boolean If the unmount success
     */
    public synchronized boolean sync() {
        if (mRequiresSync) {
            Log.i(TAG, "Syncing underlaying storage");
            mRequiresSync = false;
            // Sync the underlying storage
            try {
                TVFS.sync(mStorageRoot,
                        BitField.of(CLEAR_CACHE)
                                .set(FORCE_CLOSE_INPUT, true)
                                .set(FORCE_CLOSE_OUTPUT, true));
                return true;
            } catch (IOException e) {
                Log.e(TAG, String.format("Failed to sync secure storage: %s", mStorageRoot, e));
                return false;
            }
        }
        return true;
    }

