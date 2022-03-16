    /**
     * {@inheritDoc}
     */
    @Override
    public void onPartialResult(final Object partialResults) {
        try {
            // Do not saturate ui thread
            if (this.mDrawingFolderUsage) {
                return;
            }

            // Clone the reference
            FsoPropertiesDialog.this.mFolderUsage =
                    (FolderUsage)(((FolderUsage)partialResults).clone());
            printFolderUsage(true, false);
        } catch (Exception ex) {/**NON BLOCK**/}
    }

