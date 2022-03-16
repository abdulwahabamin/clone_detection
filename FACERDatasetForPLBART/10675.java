    /**
     * Method that converts the list of file system object to a search result.
     *
     * @param files The files to convert
     * @param queries The terms of the search
     * @return List<SearchResult> The files converted
     */
    public static List<SearchResult> convertToResults(List<FileSystemObject> files, Query queries) {
        //Converts the list of files in a list of search results
        List<SearchResult> results = new ArrayList<SearchResult>(files.size());
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = files.get(i);
            results.add( convertToResult(fso, queries) );
        }
        return results;
    }

