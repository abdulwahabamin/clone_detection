    /**
     * Method that verifies if the current storage is open and mount it
     *
     * @param ctx The current context
     * @throws CancelledOperationException If the operation was cancelled (by the user)
     * @throws AuthenticationException If the secure storage isn't unlocked
     * @throws NoSuchFileOrDirectory If the secure storage isn't accessible
     */
    @SuppressWarnings("deprecation")
    public synchronized void mount(Context ctx)
            throws CancelledOperationException, AuthenticationFailedException,
            NoSuchFileOrDirectory {
        if (!mIsMounted) {
            File root = mStorageRoot.getFile();
            try {
                boolean newStorage = !root.exists();
                mStorageRoot.mount();
                if (newStorage) {
                    // Force a synchronization
                    mRequiresSync = true;
                    sync();
                } else {
                    // Remove any previous cache files (if not sync invoked)
                    clearCache(ctx);
                }

                // The device is mounted
                mIsMounted = true;

                // Send an broadcast to notify that the mount state of this filesystem changed
                Intent intent = new Intent(FileManagerSettings.INTENT_MOUNT_STATUS_CHANGED);
                intent.putExtra(FileManagerSettings.EXTRA_MOUNTPOINT,
                        getVirtualMountPoint().toString());
                intent.putExtra(FileManagerSettings.EXTRA_STATUS, MountExecutable.READWRITE);
                getCtx().sendBroadcast(intent);

            } catch (IOException ex) {
                if (ex.getCause() != null && ex.getCause() instanceof CancelledOperation) {
                    throw new CancelledOperationException();
                }
                if (ex.getCause() != null && ex.getCause() instanceof RaesAuthenticationException) {
                    throw new AuthenticationFailedException(ctx.getString(
                            R.string.secure_storage_unlock_failed));
                }
                Log.e(TAG, String.format("Failed to open secure storage: %s", root, ex));
                throw new NoSuchFileOrDirectory();
            }
        }
    }

