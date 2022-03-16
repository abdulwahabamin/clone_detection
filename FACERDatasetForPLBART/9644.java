    /**
     * Constructor of <code>SearchResult</code>.
     *
     * @param relevance The relevance of the search
     * @param fso The file system object found
     */
    public SearchResult(double relevance, FileSystemObject fso) {
        super();
        this.mRelevance = relevance;
        this.mFso = fso;
    }

