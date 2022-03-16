    /**
     * Method that allows media scan in the directory (removes the .nomedia file)
     *
     * @param nomedia The .nomedia file
     */
    private void allowMediaScan(final File nomedia) {
        // Delete .nomedia file. The file should exist here

        // .nomedia is a directory? Then ask the user prior to remove completely the folder
        if (nomedia.isDirectory()) {
            // confirm removing the dir
            AlertDialog alert = DialogHelper.createYesNoDialog(
                this.mContext,
                R.string.fso_delete_nomedia_dir_title,
                R.string.fso_delete_nomedia_dir_body,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_POSITIVE) {
                            boolean ret = FileHelper.deleteFolder(nomedia);
                            if (!ret) {
                                DialogHelper.showToast(
                                    FsoPropertiesDialog.this.mContext,
                                    FsoPropertiesDialog.this.mContext.getString(
                                            R.string.fso_failed_to_allow_media_scan),
                                    Toast.LENGTH_SHORT);
                                FsoPropertiesDialog.this.mIgnoreCheckEvents = true;
                                FsoPropertiesDialog.this.mChkNoMedia.setChecked(true);
                                return;
                            }

                            // Refresh the listview
                            FsoPropertiesDialog.this.mHasChanged = true;

                        } else {
                            FsoPropertiesDialog.this.mIgnoreCheckEvents = true;
                            FsoPropertiesDialog.this.mChkNoMedia.setChecked(true);
                        }
                    }
                });
            DialogHelper.delegateDialogShow(this.mContext, alert);

        // .nomedia file is not empty?  Then ask the user prior to remove the file
        } else if (nomedia.length() != 0) {
            // confirm removing non empty file
            AlertDialog alert = DialogHelper.createYesNoDialog(
                this.mContext,
                R.string.fso_delete_nomedia_non_empty_title,
                R.string.fso_delete_nomedia_non_empty_body,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_POSITIVE) {
                            if (!nomedia.delete()) {
                                DialogHelper.showToast(
                                    FsoPropertiesDialog.this.mContext,
                                    FsoPropertiesDialog.this.mContext.getString(
                                            R.string.fso_failed_to_allow_media_scan),
                                    Toast.LENGTH_SHORT);
                                FsoPropertiesDialog.this.mIgnoreCheckEvents = true;
                                FsoPropertiesDialog.this.mChkNoMedia.setChecked(true);
                                return;
                            }

                            // Refresh the listview
                            FsoPropertiesDialog.this.mHasChanged = true;

                        } else {
                            FsoPropertiesDialog.this.mIgnoreCheckEvents = true;
                            FsoPropertiesDialog.this.mChkNoMedia.setChecked(true);
                        }
                    }
                });
            DialogHelper.delegateDialogShow(this.mContext, alert);

        // Normal .nomedia file
        } else {
            if (!nomedia.delete()) {
                //failed to delete .nomedia file
                DialogHelper.showToast(
                    this.mContext,
                    this.mContext.getString(
                            R.string.fso_failed_to_allow_media_scan),
                    Toast.LENGTH_SHORT);
                FsoPropertiesDialog.this.mIgnoreCheckEvents = true;
                FsoPropertiesDialog.this.mChkNoMedia.setChecked(true);
                return;
            }

            // Refresh the listview
            FsoPropertiesDialog.this.mHasChanged = true;
        }
    }

