    /**
     * Constructor of <code>RecentSearchesContentProvider</code>.
     */
    public RecentSearchesContentProvider() {
        super();
        setupSuggestions(AUTHORITY, MODE);
    }

