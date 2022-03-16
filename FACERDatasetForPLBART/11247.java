    /**
     * Method that dispose the elements of the adapter.
     */
    public void dispose() {
        if (this.mIconHolder != null) {
            this.mIconHolder.cleanup();
        }
        this.mDisposed = true;
        clear();
        this.mIconHolder = null;
    }

