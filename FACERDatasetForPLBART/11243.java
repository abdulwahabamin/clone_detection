    /**
     * Adds a new Search Result to the buffer
     */
    public void addNewItem(SearchActivity.DataHolder data) {
        if (mDisposed) {
            return;
        }

        add(data);
    }

