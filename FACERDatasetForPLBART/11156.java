    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Different actions depending on user preference

        // Get the adapter, the search result and the fso
        SearchResultAdapter adapter = ((SearchResultAdapter)parent.getAdapter());
        SearchResult searchResult = adapter.getItem(position).getSearchResult();
        FileSystemObject fso = searchResult.getFso();

        // Open the actions menu
        onRequestMenu(fso);
        return true; //Always consume the event
    }

