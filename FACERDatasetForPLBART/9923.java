    /**
     * Method that cancels the folder usage command execution
     */
    private void cancelFolderUsageCommand() {
        if (this.mComputeFolderStatistics) {
            // Cancel the folder usage command
            try {
                if (this.mFolderUsageExecutable != null &&
                    this.mFolderUsageExecutable.isCancellable() &&
                    !this.mFolderUsageExecutable.isCancelled()) {
                    this.mFolderUsageExecutable.cancel();
                }
            } catch (Exception ex) {
                Log.e(TAG, "Failed to cancel the folder usage command", ex); //$NON-NLS-1$
            }
        }
    }

