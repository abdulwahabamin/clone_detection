    /**
     * Constructor of <code>SearchResultAdapter</code>.
     *
     * @param context The current context
     * @param files The list of file system objects
     * @param itemViewResourceId The identifier of the layout that represents an item
     * of the list adapter
     * @param queries The query object used to make the result of this search
     */
    public SearchResultAdapter(
            Context context, List<SearchActivity.DataHolder> files, int itemViewResourceId,
            Query queries, IconHolder iconHolder) {
        super(context, RESOURCE_ITEM_NAME, files);
        mHandler = new Handler(context.getMainLooper());

        this.mDisposed = false;
        this.mIconHolder = iconHolder;
        this.mItemViewResourceId = itemViewResourceId;
        this.mQueries = queries.getQueries();

        // determine the sort order of search results
        setSortResultMode();
    }

