    public void search(@NonNull String query, Bundle bundle, @NonNull SearchCallback searchCallback) {
        this.query = query;
        this.bundle = bundle;
        this.searchCallback = searchCallback;
        if (bundle != null && bundle.containsKey(SEARCH_LIMIT)) {
            limit = bundle.getInt(SEARCH_LIMIT, limit);
        }
        searchAsync(query);
    }

