    /**
     * Method that removes all items and display a message.
     * @hide
     */
    void removeAll() {
        SearchResultAdapter adapter = (SearchResultAdapter)this.mSearchListView.getAdapter();
        adapter.clear();
        this.mSearchListView.setSelection(0);
        toggleResults(false, true);
    }

