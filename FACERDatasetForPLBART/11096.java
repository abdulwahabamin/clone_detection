    /**
     * Method that removes the recent suggestions on search activity
     * @hide
     */
    void clearRecentSearchTerms() {
        SearchRecentSuggestions suggestions =
                new SearchRecentSuggestions(getActivity(),
                        RecentSearchesContentProvider.AUTHORITY,
                        RecentSearchesContentProvider.MODE);
        suggestions.clearHistory();
        Preferences.setLastSearch(null);
    }

