    /**
     * Method that recycles this object
     */
    public void recycle() {
        if (this.mAdapter != null) {
            this.mAdapter.dispose();
        }
    }

