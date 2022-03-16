    /**
     * {@inheritDoc}
     */
    @Override
    public void onAsyncEnd(final boolean cancelled) {
        try {
            // Clone the reference
            FsoPropertiesDialog.this.mFolderUsage =
                    (FolderUsage)this.mFolderUsageExecutable.getFolderUsage().clone();
            printFolderUsage(true, cancelled);
        } catch (Exception ex) {/**NON BLOCK**/}
    }

