    /**
     * Method that notifies the ending of the process.
     *
     * @param ex The exception, only if the process exit with a exception.
     * Otherwise null
     * @hide
     */
    void notifyProcessExit(Exception ex) {
        synchronized (this.mSync) {
            if (this.mActive) {
                this.mActive = false;
                this.mFinished = true;
                this.mSync.notify();
                if (ex != null) {
                    Log.w(TAG, "Exit with exception", ex); //$NON-NLS-1$
                }
            }
        }
    }

