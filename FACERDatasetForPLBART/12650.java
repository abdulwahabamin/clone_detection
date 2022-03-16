    /**
     * Method that sets the console
     * @param cmd the mCmd to set
     */
    public void setCmd(AsyncResultExecutable cmd) {
        this.mCmd = cmd;

        // Enable cancel the script after 3 seconds.
        this.mTvOutput.postDelayed(new Runnable() {
            @Override
            public void run() {
                ExecutionDialog.this.mDialog.setCancelable(true);
                ExecutionDialog.this.mDialog.getButton(
                        DialogInterface.BUTTON_NEUTRAL).setEnabled(true);
            }
        }, 5000L);
    }

