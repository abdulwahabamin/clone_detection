    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancel() {
        try {
            synchronized (this.mSync) {
                // ensure the program is running before attempting to cancel
                // there won't be a corresponding lock.notify() otherwise
                if (!mEnded) {
                    this.mCancelled = true;
                    this.mSync.wait(5000L);
                }
            }
        } catch (Exception e) {/**NON BLOCK**/}
        return true;
    }

