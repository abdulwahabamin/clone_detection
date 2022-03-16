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
            TFile f = getConsole().buildRealFile(mFile);
            this.mBuffer = new BufferedOutputStream(new TFileOutputStream(f), getBufferSize());
            return this.mBuffer;
        } catch (IOException ioEx) {
            if (isTrace()) {
                Log.e(TAG, "Result: FAILED. IOException", ioEx); //$NON-NLS-1$
            }
            throw ioEx;
        }
    }

