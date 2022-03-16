    /**
     * Method that judges whether the dialog is showing.
     */
    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

