    /**
     * Method that set a message in the dialog. If the message is {@link null} then
     * the view is hidden
     *
     * @param msg The message to show. {@link null} to hide the dialog
     * @hide
     */
    void setMsg(String msg) {
        this.mInfoMsgView.setText(msg);
        this.mInfoMsgView.setVisibility(
                mIsVirtual || !this.mIsAdvancedMode || (this.mHasPrivileged && msg == null) ?
                        View.GONE :
                        View.VISIBLE);
    }

