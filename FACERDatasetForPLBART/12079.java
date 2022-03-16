    /**
     * Method that request a reset of the current password
     */
    public void requestReset(final Context ctx) {
        AsyncTask<Void, Void, Boolean> task = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                boolean result = false;

                // Unmount the filesystem
                if (mIsMounted) {
                    unmount();
                }
                try {
                    SecureStorageKeyManagerProvider.SINGLETON.reset();

                    // Mount with the new key
                    mount(ctx);

                    // In order to claim a write, we need to be sure that an operation is
                    // done to disk before unmount the device.
                    try {
                        String testName = UUID.randomUUID().toString();
                        TFile test = new TFile(getSecureStorageRoot(), testName);
                        test.createNewFile();
                        test.rm();
                        result = true;
                    } catch (IOException ex) {
                        ExceptionUtil.translateException(ctx, ex);
                    }

                } catch (Exception ex) {
                    ExceptionUtil.translateException(ctx, ex);
                } finally {
                    unmount();
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

