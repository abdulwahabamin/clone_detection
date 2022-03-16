    /**
     * Method that echoes the stderr
     *
     * @param stdin The buffer of the stderr
     * @hide
     */
    void toStdErr(String stderr) {
        //Audit (if not cancelled)
        if (!this.mCancelled && isTrace()) {
            Log.v(TAG,
                    String.format(
                            "stderr: %s", stderr)); //$NON-NLS-1$
        }
    }

