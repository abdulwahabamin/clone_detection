    /**
     * Method that dispose the elements of the adapter.
     */
    public void dispose() {
        clear();
        if (mIconHolder != null) {
            mIconHolder.cleanup();
            mIconHolder = null;
        }
        this.mSelectedItems.clear();
    }

