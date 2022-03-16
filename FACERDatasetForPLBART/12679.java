    /**
     * Method that computes the disk usage of the folder in background
     */
    private void computeFolderUsage() {
        try {
            if (this.mFso instanceof Symlink && ((Symlink) this.mFso).getLinkRef() != null) {
                this.mFolderUsageExecutable =
                    CommandHelper.getFolderUsage(
                            this.mContext,
                            ((Symlink) this.mFso).getLinkRef().getFullPath(), this, null);
            } else {
                this.mFolderUsageExecutable =
                    CommandHelper.getFolderUsage(
                        this.mContext, this.mFso.getFullPath(), this, null);
            }
        } catch (Exception cause) {
            //Capture the exception
            ExceptionUtil.translateException(this.mContext, cause, true, false);
            this.mTvSize.setText(R.string.error_message);
            this.mTvContains.setText(R.string.error_message);
        }
    }

