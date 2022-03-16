    public QueueDrawerAdapter(Context context, ArrayList<Integer> playbackIndecesList) {
        super(context, R.layout.queue_drawer_list_layout, playbackIndecesList);

        mContext = context;
        mApp = (Common) mContext.getApplicationContext();
        mColors = UIElementsHelper.getQuickScrollColors(context);
    }

