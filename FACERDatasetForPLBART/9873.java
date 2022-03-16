    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_NEUTRAL:
                // Cancel the program?
                try {
                    if (this.mCmd != null && !this.mFinished) {
                        if (this.mCmd.isCancellable() && !this.mCmd.isCancelled()) {
                            this.mCmd.cancel();
                        }
                    }
                } catch (Exception e) {/**NON BLOCK**/}
                this.mDialog.dismiss();
                break;

            default:
                break;
        }
    }

