    /**
     * Method that request a delete of the current password
     */
    @SuppressWarnings("deprecation")
    public void requestDelete(final Context ctx) {
        AsyncTask<Void, Void, Boolean> task = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                boolean result = false;

                // Unmount the filesystem
                if (mIsMounted) {
                    unmount();
                }
                try {
                    SecureStorageKeyManagerProvider.SINGLETON.delete();

                    // Test mount/unmount
                    mount(ctx);
                    unmount();

                    // Password is valid. Delete the storage
                    mStorageRoot.getFile().delete();

                    // Send an broadcast to notify that the mount state of this filesystem changed
                    Intent intent = new Intent(FileManagerSettings.INTENT_MOUNT_STATUS_CHANGED);
                    intent.putExtra(FileManagerSettings.EXTRA_MOUNTPOINT,
                            getVirtualMountPoint().toString());
                    intent.putExtra(FileManagerSettings.EXTRA_STATUS, MountExecutable.READONLY);
                    getCtx().sendBroadcast(intent);

                    result = true;

                } catch (Exception ex) {
                    ExceptionUtil.translateException(ctx, ex);
                }

                return result;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (result) {
                    // Success
                    DialogHelper.showToast(ctx, R.string.msgs_success, Toast.LENGTH_SHORT);
                }
            }

        };
        task.execute();
    }

