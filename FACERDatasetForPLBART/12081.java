    /**
     * {@inheritDoc}
     */
    public boolean unmount() {
        // Unmount the filesystem and cancel the cached key
        mRequiresSync = true;
        boolean ret = sync();
        if (ret) {
            SecureStorageKeyManagerProvider.SINGLETON.unmount();
        }
        mIsMounted = false;

        // Send an broadcast to notify that the mount state of this filesystem changed
        Intent intent = new Intent(FileManagerSettings.INTENT_MOUNT_STATUS_CHANGED);
        intent.putExtra(FileManagerSettings.EXTRA_MOUNTPOINT,
                getVirtualMountPoint().toString());
        intent.putExtra(FileManagerSettings.EXTRA_STATUS, MountExecutable.READONLY);
        getCtx().sendBroadcast(intent);

        return mIsMounted;
    }

