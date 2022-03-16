    /**
     * Locates the search view in the action bar, and prepares it for city searching.
     *
     * @param menu options menu containing the city search view
     */
    private void setCitySearching(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.mi_search_cities);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint(getResources().getString(R.string.city_searchable_hint));
    }

