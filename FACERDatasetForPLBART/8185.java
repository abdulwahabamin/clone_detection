    /**
     * Check the dirty state of the editor, and ask the user to save the changes
     * prior to exit.
     */
    public void checkDirtyState() {
        if (this.mDirty) {
            AlertDialog dlg = DialogHelper.createYesNoDialog(
                    this,
                    R.string.editor_dirty_ask_title,
                    R.string.editor_dirty_ask_msg,
                    new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == DialogInterface.BUTTON_POSITIVE) {
                                dialog.dismiss();
                                setResult(Activity.RESULT_OK);
                                finish();
                            }
                        }
                    });
            DialogHelper.delegateDialogShow(this, dlg);
            return;
        }
        setResult(Activity.RESULT_OK);
        finish();
    }

