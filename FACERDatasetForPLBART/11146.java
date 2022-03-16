    private DataHolder generateDataHolder(SearchResult result) {
        //Build the data holder
        final FileSystemObject fso = result.getFso();
        final Drawable icon = mIconHolder.getDrawable(
                MimeTypeHelper.getIcon(this, fso));
        final CharSequence highlightedName;
        if (mHighlightTerms) {
            highlightedName = SearchHelper.getHighlightedName(result, mQuery.getQueries(),
                    mHighlightColor);
        } else {
            highlightedName = SearchHelper.getNonHighlightedName(result);
        }
        final String parent = new File(result.getFso().getFullPath()).getParent();
        Float relevance = mShowRelevanceWidget ? ((float)result.getRelevance() * 100)
                / SearchResult.MAX_RELEVANCE : null;
        final MimeTypeHelper.MimeTypeCategory category = MimeTypeHelper.getCategory(this, fso);

        SearchActivity.DataHolder holder = new SearchActivity.DataHolder(result, icon,
                highlightedName, parent, relevance, category);
        return holder;
    }

