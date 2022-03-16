    @Override
    public boolean onQueryTextSubmit(final String query) {
        searchResultProvider.search(query, null, searchCallback);
        hideInputManager();
        return true;
    }

