    /**
     * Method that returns the data of the adapter.
     *
     * @return List<SearchResult> The adapter data
     */
    public List<SearchResult> getData() {
        int cc = getCount();
        final List<SearchResult> data = new ArrayList<SearchResult>(cc);
        for (int i = 0; i < cc; i++) {
            data.add(getItem(i).getSearchResult());
        }
        return data;
    }

