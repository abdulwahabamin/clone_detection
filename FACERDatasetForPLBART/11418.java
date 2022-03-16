    /**
     * {@inheritDoc}
     */
    @Override
    public boolean end() {
        try {
            synchronized (this.mSync) {
                this.mEnded = true;
                this.mSync.wait(5000L);
            }
        } catch (Exception e) {/**NON BLOCK**/}
        return true;
    }

