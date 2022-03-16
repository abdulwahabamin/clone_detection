    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream createOutputStream() throws IOException {
        try {
            // Wait until command is ready
            synchronized (this.mWriteSync) {
                if (!this.mReady) {
                    try {
                        this.mWriteSync.wait(TIMEOUT);
                    } catch (Exception e) {/**NON BLOCK**/}
                }
            }
            this.mBuffer = new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(this.mFile)), getBufferSize());
            return this.mBuffer;
        } catch (IOException ioEx) {
            if (isTrace()) {
                Log.e(TAG, "Result: FAILED. IOException", ioEx); //$NON-NLS-1$
            }
            throw ioEx;
        }
    }

