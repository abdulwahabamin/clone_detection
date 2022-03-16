    /**
     * Method that shows the dialog.
     */
    public void show() {
        DialogHelper.delegateDialogShow(this.mContext, this.mDialog);

        // Set user preferences
        this.mDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(false);
        this.mGrid.post(new Runnable() {
            @Override
            public void run() {
                if (!checkUserPreferences()) {
                    // Recall for check user preferences
                    AssociationsDialog.this.mGrid.postDelayed(this, 50L);
                }
            }
        });
    }

