    /**
     * Constructor of <code>TwoColumnsMenuListAdapter</code>.
     *
     * @param context The current context
     * @param menuResourceId The resource identifier
     * @param multiSelect Whether the menu allows for single or multi select
     */
    public TwoColumnsMenuListAdapter(Context context, int menuResourceId, boolean multiSelect) {
        super(context, menuResourceId, multiSelect);
        this.mContext = context;

        //Separators are not support in this kind of adapter
        removeSeparators();
    }

