    /**
     * Method that verifies if the process had exited.
     * @hide
     */
    void checkIfProcessExits() {
        try {
            if (this.mProc != null) {
                synchronized (this.mSync) {
                    this.mProc.exitValue();
                }
                this.mActive = false; //Exited
            }
        } catch (IllegalThreadStateException itsEx) {
            //Not exited
        }
    }

