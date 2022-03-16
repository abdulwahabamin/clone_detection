    /**
     * Method that prevents media scan in the directory (creates a new .nomedia file)
     *
     * @param nomedia The .nomedia file
     */
    private void preventMediaScan(final File nomedia) {
        // Create .nomedia file. The file should not exist here
        try {
            if (!nomedia.createNewFile()) {
                // failed to create .nomedia file
                DialogHelper.showToast(
                    this.mContext,
                    this.mContext.getString(
                            R.string.fso_failed_to_prevent_media_scan),
                    Toast.LENGTH_SHORT);
                this.mIgnoreCheckEvents = true;
                this.mChkNoMedia.setChecked(false);
                return;
            }

            // Refresh the listview
            this.mHasChanged = true;

        } catch (IOException ex) {
            // failed to create .nomedia file
            ExceptionUtil.translateException(this.mContext, ex, true, false, null);
            DialogHelper.showToast(
                this.mContext,
                this.mContext.getString(
                        R.string.fso_failed_to_prevent_media_scan),
                Toast.LENGTH_SHORT);
            this.mIgnoreCheckEvents = true;
            this.mChkNoMedia.setChecked(false);
        }
    }

