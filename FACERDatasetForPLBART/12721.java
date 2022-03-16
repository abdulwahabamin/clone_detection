    /**
     * Set a listener to be invoked when the dialog is cancelled.
     * <p>
     * This will only be invoked when the dialog is cancelled, if the creator
     * needs to know when it is dismissed in general, use
     * {@link #setOnDismissListener}.
     *
     * @param onCancelListener The {@link "OnCancelListener"} to use.
     */
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

