    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream createOutputStream() throws IOException {

        // Wait until command is ready
        synchronized (this.mWriteSync) {
            if (!this.mReady) {
                try {
                    this.mWriteSync.wait(TIMEOUT);
                } catch (Exception e) {/**NON BLOCK**/}
            }
        }
        return getProgramListener().getOutputStream();
    }

