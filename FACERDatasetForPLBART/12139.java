    /**
     * Method that echoes the stdin
     *
     * @param stdin The buffer of the stdin
     * @hide
     */
    void toStdIn(String stdin) {
        //Audit (if not cancelled)
        if (!this.mCancelled && isTrace() && stdin.length() > 0) {
            Log.v(TAG,
                    String.format(
                            "stdin: %s", stdin)); //$NON-NLS-1$
        }
    }

