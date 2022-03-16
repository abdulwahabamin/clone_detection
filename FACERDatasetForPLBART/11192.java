    /**
     * Constructor of <code>AssociationsAdapter</code>.
     *
     * @param context The current context
     * @param parent The adapter view
     * @param intents The intents info
     * @param onItemClickListener The listener for listen action clicks
     */
    public AssociationsAdapter(
            Context context, AdapterView<?> parent,
            List<ResolveInfo> intents, OnItemClickListener onItemClickListener) {
        super(context, RESOURCE_ITEM_NAME, intents);
        this.mOnItemClickListener = onItemClickListener;
        this.mParent = parent;

        //Do cache of the data for better performance
        processData(intents);
    }

