    private void setupSearchView(MenuItem searchItem) {
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                searchQuery = null;
                updateData();
                return true;
            }
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }
        });
        SearchManager searchManager = (SearchManager) (getSystemService(Context.SEARCH_SERVICE));
        searchView = (SearchView) searchItem.getActionView();
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
            searchView.clearFocus();
            searchView.setOnQueryTextListener(onQueryTextListener);
        }
    }

