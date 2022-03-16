    /**
     * Method that redraws the information about folder usage
     *
     * @param computing If the process if computing the data
     * @param cancelled If the process was cancelled
     */
    private void printFolderUsage(final boolean computing, final boolean cancelled) {
        // Mark that a drawing is in progress
        this.mDrawingFolderUsage = true;

        final Resources res = this.mContext.getResources();
        if (cancelled) {
            try {
                FsoPropertiesDialog.this.mTvSize.setText(R.string.cancelled_message);
                FsoPropertiesDialog.this.mTvContains.setText(R.string.cancelled_message);
            } catch (Throwable e) {/**NON BLOCK**/}

            // End of drawing
            this.mDrawingFolderUsage = false;
        } else {
            // Calculate size prior to use ui thread
            final String size = FileHelper.getHumanReadableSize(this.mFolderUsage.getTotalSize());

            // Compute folders and files string
            String folders = res.getQuantityString(
                                        R.plurals.n_folders,
                                        this.mFolderUsage.getNumberOfFolders(),
                                        Integer.valueOf(this.mFolderUsage.getNumberOfFolders()));
            String files = res.getQuantityString(
                                        R.plurals.n_files,
                                        this.mFolderUsage.getNumberOfFiles(),
                                        Integer.valueOf(this.mFolderUsage.getNumberOfFiles()));
            final String contains = res.getString(
                                        R.string.fso_properties_dialog_folder_items,
                                        folders, files);

            // Update the dialog
            ((Activity)this.mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (computing) {
                        FsoPropertiesDialog.this.mTvSize.setText(
                                res.getString(R.string.computing_message, size));
                        FsoPropertiesDialog.this.mTvContains.setText(
                                res.getString(R.string.computing_message_ln, contains));
                    } else {
                        FsoPropertiesDialog.this.mTvSize.setText(size);
                        FsoPropertiesDialog.this.mTvContains.setText(contains);
                    }

                    // End of drawing
                    FsoPropertiesDialog.this.mDrawingFolderUsage = false;
                }
            });
        }
    }

