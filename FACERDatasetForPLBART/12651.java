    /**
     * Method that shows the dialog.
     */
    public void show() {
        DialogHelper.delegateDialogShow(this.mContext, this.mDialog);
        this.mDialog.setCancelable(false);
        this.mDialog.getButton(DialogInterface.BUTTON_NEUTRAL).setEnabled(false);
    }

