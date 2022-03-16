    /**
     * Constructor of <code>SearchInfoParcelable</code>.
     */
    public SearchInfoParcelable(String searchDirectory, List<SearchResult> searchResultList, Query searchQuery) {
        super();
        mSearchDirectory = searchDirectory;
        mSearchResultList = searchResultList;
        mSearchQuery = searchQuery;
        setTitle();
    }

