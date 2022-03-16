    /**
     * Method that removes the {@link FileSystemObject} reference
     *
     * @param fso The file system object
     */
    private void removeItem(FileSystemObject fso) {
        SearchResultAdapter adapter =
                (SearchResultAdapter)this.mSearchListView.getAdapter();
        if (adapter != null) {
            int pos = adapter.getPosition(fso);
            if (pos != -1) {
                adapter.remove(adapter.getItem(pos));
            }

            // Toggle resultset?
            toggleResults(adapter.getCount() > 0, true);
            setFoundItems(adapter.getCount(), this.mSearchDirectory);
        }
    }

