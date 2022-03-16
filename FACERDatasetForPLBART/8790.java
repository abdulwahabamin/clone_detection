    /**
     * {@inheritDoc}
     */
    @Override
    public boolean end() {
        try {
            // ensure the program is running before attempting to terminate
            if (!mEnded) {
                this.mEnded = true;
                this.mSync.wait(5000L);
            }
        } catch (Exception e) {/**NON BLOCK**/}
        return true;
    }

