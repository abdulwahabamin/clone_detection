    /**
     * {@inheritDoc}
     */
    @Override
    public void onSelectionChanged(final List<FileSystemObject> selectedItems) {
        if (this.mOnNavigationSelectionChangedListener != null) {
            this.mOnNavigationSelectionChangedListener.onSelectionChanged(this, selectedItems);
        }
    }

