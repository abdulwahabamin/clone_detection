    /**
     * Method that do the search.
     *
     * @param voiceQuery Indicates if the query is from voice recognition
     * @param query The terms of the search
     * @param searchDirectory The directory of the search
     * @hide
     */
    void doSearch(
            final boolean voiceQuery, final Query query, final String searchDirectory) {
        // Load settings
        this.mHighlightTerms = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_HIGHLIGHT_TERMS.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_HIGHLIGHT_TERMS.
                        getDefaultValue()).booleanValue());
        this.mShowRelevanceWidget = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_SHOW_RELEVANCE_WIDGET.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_SHOW_RELEVANCE_WIDGET.
                        getDefaultValue()).booleanValue());

        // Recovers the user preferences about save suggestions
        boolean saveSuggestions = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_SAVE_SEARCH_TERMS.getId(),
                ((Boolean) FileManagerSettings.SETTINGS_SAVE_SEARCH_TERMS.
                        getDefaultValue()).booleanValue());
        if (saveSuggestions) {
            //Save every query for use as recent suggestions
            SearchRecentSuggestions suggestions =
                    new SearchRecentSuggestions(this,
                            RecentSearchesContentProvider.AUTHORITY,
                            RecentSearchesContentProvider.MODE);
            if (!voiceQuery) {
                List<String> queries = query.getQueries();
                int cc = queries.size();
                for (int i = 0; i < cc; i++) {
                    suggestions.saveRecentQuery(queries.get(i), null);
                }
            }
        }

        //Set the listview
        if (this.mSearchListView.getAdapter() != null) {
            ((SearchResultAdapter)this.mSearchListView.getAdapter()).dispose();
        }
        this.mResultList = new ArrayList<FileSystemObject>();
        mAdapter =
                new SearchResultAdapter(this,
                        mAdapterList, R.layout.search_item,
                        this.mQuery, mIconHolder);
        this.mSearchListView.setAdapter(mAdapter);

        //Set terms
        if (mMimeTypeCategories == null) {
            this.mSearchTerms.setText(
                    Html.fromHtml(getString(R.string.search_terms, query.getTerms())));
        } else {
            ArrayList<String> localizedNames = new ArrayList<String>(mMimeTypeCategories.size());
            for (MimeTypeCategory category : mMimeTypeCategories) {
                localizedNames
                        .add(NavigationActivity.MIME_TYPE_LOCALIZED_NAMES[category.ordinal()]);
            }
             this.mSearchTerms.setText(
                     Html.fromHtml(getString(R.string.search_terms, localizedNames)));
        }

        //Now, do the search in background
        this.mSearchListView.post(new Runnable() {
            @Override
            public void run() {
                try {
                    // Execute the query (search in background)
                    SearchActivity.this.mExecutable =
                            CommandHelper.findFiles(
                                    SearchActivity.this,
                                    searchDirectory,
                                    mQuery,
                                    mAsyncListener,
                                    null);

                } catch (Throwable ex) {
                    //Remove all elements
                    try {
                        SearchActivity.this.removeAll();
                    } catch (Throwable ex2) {
                        /**NON BLOCK**/
                    }

                    //Capture the exception
                    Log.e(TAG, "Search failed", ex); //$NON-NLS-1$
                    DialogHelper.showToast(
                            SearchActivity.this,
                            R.string.search_error_msg, Toast.LENGTH_SHORT);
                    toggleResults(false, true);
                }
            }
        });
    }

