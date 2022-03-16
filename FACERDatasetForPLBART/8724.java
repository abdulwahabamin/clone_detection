    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancel() {
        closeBuffer();
        this.mCancelled = true;
        try {
            synchronized (this.mSync) {
                this.mSync.notify();
            }
        } catch (Throwable _throw) {/**NON BLOCK**/}
        return true;
    }

