        @Override
        protected List<DataHolder> doInBackground(MimeTypeCategory... params) {
            final MimeTypeCategory category = params.length == 0
                    ? MimeTypeCategory.NONE : params[0];

            List<DataHolder> results = new ArrayList<DataHolder>();
            // Are we in ChRooted environment?
            boolean chRooted =
                    FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) == 0;

            List<SearchResult> newResults = SearchHelper.convertToResults(
                    FileHelper.applyUserPreferences(
                            mResultList, null, true, chRooted),
                    new Query().fillSlots(mQuery.getQueries()));

            for (SearchResult result : newResults) {
                // Show all results that are relevant if no filter is set or show results that are
                // relevant and match the specified category
                if (result.getRelevance() > INVALID_RELEVANCE && (MimeTypeHelper.MimeTypeCategory
                        .NONE.equals(category) || MimeTypeHelper.getCategory(SearchActivity.this,
                        result.getFso()).equals(category))) {
                    results.add(generateDataHolder(result));
                }
            }
            return results;
        }

