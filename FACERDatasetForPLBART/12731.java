    /**
     * Method that shows the alert message with the validation warning.
     *
     * @param msg The message to show
     * @param activate If the positive button must be activate
     */
    private void setMsg(String msg, boolean activate) {
        if (msg == null || msg.length() == 0) {
            this.mMsg.setVisibility(View.GONE);
            this.mMsg.setText(""); //$NON-NLS-1$
        } else {
            this.mMsg.setText(msg);
            this.mMsg.setVisibility(View.VISIBLE);
        }
        this.mDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(activate);
    }

