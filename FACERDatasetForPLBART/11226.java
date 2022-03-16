    /**
     * Constructor of <code>HighlightedSimpleMenuListAdapter</code>.
     *
     * @param context The current context
     * @param menuResourceId The resource identifier
     * @param multiSelect Whether the menu allows for single or multi select
     */
    public HighlightedSimpleMenuListAdapter(Context context, int menuResourceId,
                                            boolean multiSelect) {
        super(context, menuResourceId, multiSelect);
        this.mContext = context;
    }

