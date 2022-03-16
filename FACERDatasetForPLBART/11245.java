    /**
     * Determine the sort order for Search Results
     */
    public void setSortResultMode() {
        String defaultValue = ((ObjectStringIdentifier)FileManagerSettings.
                SETTINGS_SORT_SEARCH_RESULTS_MODE.getDefaultValue()).getId();
        String currValue = Preferences.getSharedPreferences().getString(
                FileManagerSettings.SETTINGS_SORT_SEARCH_RESULTS_MODE.getId(),
                defaultValue);
        mSearchSortResultMode = SearchSortResultMode.fromId(currValue);

        if (mSearchSortResultMode.compareTo(SearchSortResultMode.NAME) == 0) {
            mSearchResultComparator = new Comparator<SearchActivity.DataHolder>() {
                @Override
                public int compare(SearchActivity.DataHolder lhs, SearchActivity.DataHolder rhs) {
                    return FileHelper.doCompare(
                            lhs.getSearchResult().getFso(), rhs.getSearchResult().getFso(),
                            NavigationSortMode.NAME_ASC);
                }
            };

        } else if (mSearchSortResultMode.compareTo(SearchSortResultMode.RELEVANCE) == 0) {
            mSearchResultComparator = new Comparator<SearchActivity.DataHolder>() {
                @Override
                public int compare(SearchActivity.DataHolder lhs, SearchActivity.DataHolder rhs) {
                    return lhs.getSearchResult().compareTo(rhs.getSearchResult());
                }
            };
        }
    }

