    public MetadataCategoryListAdapter(Context context, int layout, Cursor cursor, String[] from, int[] to,
                                       MetadataCategoryFragment currentActivity) {
        super(context, layout, cursor, from, to, 0);
        this.mActivity = currentActivity;
        this.mUnknown = context.getString(mActivity.getUnknownStringId());

        getIndexer(cursor);
        mResources = context.getResources();
    }

