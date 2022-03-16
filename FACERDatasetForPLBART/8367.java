    /**
     * Method that restore the activity from the cached data.
     */
    private void loadFromCacheData() {
        this.mSearchListView.post(new Runnable() {
            @Override
            public void run() {
                //Toggle results
                List<SearchResult> list = SearchActivity.this.mRestoreState.getSearchResultList();
                mAdapterList.clear();
                for (SearchResult searchResult : list) {
                    mAdapterList.add(generateDataHolder(searchResult));
                }


                String directory = SearchActivity.this.mRestoreState.getSearchDirectory();
                SearchActivity.this.toggleResults(list.size() > 0, true);
                setFoundItems(list.size(), directory);

                //Set terms
                Query query = SearchActivity.this.mRestoreState.getSearchQuery();
                String terms =
                        TextUtils.join(" | ",  //$NON-NLS-1$;
                                query.getQueries().toArray(new String[]{}));
                if (terms.endsWith(" | ")) { //$NON-NLS-1$;
                    terms = ""; //$NON-NLS-1$;
                }
                SearchActivity.this.mSearchTerms.setText(
                        Html.fromHtml(getString(R.string.search_terms, terms)));

                try {
                    if (SearchActivity.this.mSearchWaiting != null) {
                        SearchActivity.this.mSearchWaiting.setVisibility(View.VISIBLE);
                    }

                    //Add list to the listview
                    if (SearchActivity.this.mSearchListView.getAdapter() != null) {
                        ((SearchResultAdapter)SearchActivity.this.
                                mSearchListView.getAdapter()).clear();
                    }
                    SearchResultAdapter adapter =
                            new SearchResultAdapter(
                                                SearchActivity.this.mSearchListView.getContext(),
                                                mAdapterList,
                                                R.layout.search_item,
                                                query, mIconHolder);
                    SearchActivity.this.mSearchListView.setAdapter(adapter);
                    SearchActivity.this.mSearchListView.setSelection(0);

                    SearchActivity.this.mQuery = query;
                    SearchActivity.this.mSearchDirectory = mRestoreState.getSearchDirectory();

                    mStreamingSearchProgress.setVisibility(View.INVISIBLE);

                } catch (Throwable ex) {
                    //Capture the exception
                    ExceptionUtil.translateException(SearchActivity.this, ex);

                } finally {
                    //Hide waiting
                    if (SearchActivity.this.mSearchWaiting != null) {
                        SearchActivity.this.mSearchWaiting.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

