    public AppThemeArrayAdapter(Context context, int textViewResourceId, CharSequence[] objects,
                                int[] ids, int i) {
        super(context, textViewResourceId, objects);
        this.context = context;
        index = i;
        resourceIds = ids;
    }

