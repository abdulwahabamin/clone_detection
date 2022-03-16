    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestRefresh(Object o, boolean clearSelection) {
        // Refresh only the item
        SearchResultAdapter adapter =
                (SearchResultAdapter)this.mSearchListView.getAdapter();
        if (adapter != null) {
            if (o instanceof FileSystemObject) {

                FileSystemObject fso = (FileSystemObject)o;
                int pos = adapter.getPosition(fso);
                if (pos >= 0) {
                    SearchResult sr = adapter.getItem(pos).getSearchResult();
                    sr.setFso(fso);
                }
            } else if (o == null) {
                // Refresh all
                List<SearchResult> results = adapter.getData();
                this.mResultList = new ArrayList<FileSystemObject>(results.size());
                int cc = results.size();
                for (int i = 0; i < cc; i++) {
                    this.mResultList.add(results.get(i).getFso());
                }
            }
        }
    }

