    /**
     * Method that checks that the write to disk operation was successfully and the
     * expected bytes are written to disk.
     * @hide
     */
    void ensureSyncWrite() {
        try {
            for (int i = 0; i < WRITE_RETRIES; i++) {
                // Configure the writer
                AsyncWriter writer = new AsyncWriter();

                // Write to disk
                final byte[] data = this.mEditor.getText().toString().getBytes();
                long expected = data.length;
                syncWrite(writer, data);

                // Sleep a bit
                Thread.sleep(150L);

                // Is error?
                if (writer.mCause != null) {
                    Log.e(TAG, "Write operation failed. Retries: " + i, writer.mCause);
                    if (i == (WRITE_RETRIES-1)) {
                        // Something was wrong. The file probably is corrupted
                        DialogHelper.showToast(
                                this, R.string.msgs_operation_failure, Toast.LENGTH_SHORT);
                        break;
                    }

                    // Retry
                    continue;
                }

                // Check that all the bytes were written
                FileSystemObject fso =
                        CommandHelper.getFileInfo(this, this.mFso.getFullPath(), true, null);
                if (fso == null || fso.getSize() != expected) {
                    Log.e(TAG, String.format(
                            "Size is not the same. Expected: %d, Written: %d. Retries: %d",
                            expected, fso == null ? -1 : fso.getSize(), i));
                    if (i == (WRITE_RETRIES-1)) {
                        // Something was wrong. The destination data is not the same
                        // as the source data
                        DialogHelper.showToast(
                                this, R.string.msgs_operation_failure, Toast.LENGTH_SHORT);
                        break;
                    }

                    // Retry
                    continue;
                }

                // Success. The file was saved
                DialogHelper.showToast(
                        this, R.string.editor_successfully_saved, Toast.LENGTH_SHORT);
                setDirty(false);

                // Send a message that allow other activities to update his data
                Intent intent = new Intent(FileManagerSettings.INTENT_FILE_CHANGED);
                intent.putExtra(
                        FileManagerSettings.EXTRA_FILE_CHANGED_KEY, this.mFso.getFullPath());
                sendBroadcast(intent);

                // Done
                break;

            }
        } catch (Exception ex) {
            // Something was wrong, but the file was NOT written
            Log.e(TAG, "The file wasn't written.", ex);
            DialogHelper.showToast(
                    this, R.string.msgs_operation_failure, Toast.LENGTH_SHORT);
        }
    }

