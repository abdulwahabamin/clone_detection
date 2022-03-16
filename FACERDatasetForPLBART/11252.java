    /**
     * Constructor of <code>SimpleMenuListAdapteSr</code>.
     *
     * @param context The current context
     * @param menuResourceId The resource identifier
     * @param multiSelect Whether the menu allows for single or multi select
     */
    public SimpleMenuListAdapter(Context context, int menuResourceId, boolean multiSelect) {
        super();
        this.mContext = context;
        this.mMenu = new MenuBuilder(context);
        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mMultiSelect = multiSelect;
        inflateMenu(menuResourceId);
    }

