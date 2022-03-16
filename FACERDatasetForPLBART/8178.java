    private void checkAndWrite() {
        // Check that we have write access
        try {
            FileHelper.ensureWriteAccess(
                    ConsoleBuilder.getConsole(this),
                    this.mFso,
                    null);

            // Write the file
            ensureSyncWrite();

        } catch (Exception ex) {
            ExceptionUtil.translateException(
                    this, ex, false, true, new OnRelaunchCommandResult() {
                @Override
                public void onSuccess() {
                    // Write the file
                    ensureSyncWrite();
                }

                @Override
                public void onFailed(Throwable cause) {/**NON BLOCK**/}

                @Override
                public void onCancelled() {/**NON BLOCK**/}
            });
        }
    }

