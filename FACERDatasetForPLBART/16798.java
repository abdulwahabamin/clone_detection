    @Override
    public boolean onQueryTextChange(final String newText) {
        if (newText.equals(query)) {
            return true;
        }
        query = newText;

        if (query.trim().equals("")) {
            searchAdapter.refreshData(new ArrayList<MediaItemWrapper>());
        } else {
            searchResultProvider.search(query, null, searchCallback);
        }

        return true;
    }

