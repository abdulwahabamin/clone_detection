    /**
     * Method that refresh the view data.
     *
     * @param restore Restore previous position
     */
    public void refresh(boolean restore) {
        FileSystemObject fso = null;
        // Try to restore the previous scroll position
        if (restore) {
            try {
                if (this.mAdapterView != null && this.mAdapter != null) {
                    int position = this.mAdapterView.getFirstVisiblePosition();
                    fso = this.mAdapter.getItem(position);
                }
            } catch (Throwable _throw) {/**NON BLOCK**/}
        }
        refresh(fso);
    }

