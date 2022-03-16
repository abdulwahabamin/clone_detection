    /**
     * {@inheritDoc}
     */
    @Override
    public boolean end() {
        closeBuffer();
        try {
            synchronized (this.mSync) {
                this.mSync.notify();
            }
        } catch (Throwable _throw) {/**NON BLOCK**/}
        return true;
    }

