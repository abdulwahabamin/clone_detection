    /**
     * Ensures the search result meets user preferences and passes it to the adapter for display
     *
     * @param result FileSystemObject that matches the search result criteria
     */
    private void showSearchResult(FileSystemObject result) {
        new ProcessSearchResult(this).execute(result);
    }

