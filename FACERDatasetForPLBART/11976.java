    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartParsePartialResult() {
        synchronized (this.mWriteSync) {
            this.mReady = true;
            this.mWriteSync.notify();
        }
    }

