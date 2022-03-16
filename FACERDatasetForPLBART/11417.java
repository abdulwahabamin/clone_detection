    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancel() {
        try {
            synchronized (this.mSync) {
                if (this.mEnded || this.mCancelled) {
                    this.mCancelled = true;
                    return true;
                }
                this.mCancelled = true;
                this.mSync.wait(5000L);
            }
        } catch (Exception e) {/**NON BLOCK**/}
        return true;
    }

