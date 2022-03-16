    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancel() {
        try {
            synchronized (this.mSync) {
                this.mCancelled = true;
            }
        } catch (Throwable _throw) {/**NON BLOCK**/}
        return true;
    }

