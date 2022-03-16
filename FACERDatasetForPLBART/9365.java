    /**
     * Method that notifies the ending of the command execution.
     * @hide
     */
    void notifyProcessFinished() {
        synchronized (this.mSync) {
            if (this.mActive) {
                this.mFinished = true;
                this.mSync.notify();
            }
        }
    }

