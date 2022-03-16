    /**
     * Method that converts a file system object to a search result.
     *
     * @param fso FileSystemObject that needs to be converted to a SearchResult
     * @param queries The terms of the search
     * @return SearchResult
     */
    public static SearchResult convertToResult(FileSystemObject fso, Query queries) {
        double relevance = calculateRelevance(fso, queries);
        return new SearchResult(relevance, fso);
    }

