    public GridViewAdapter(Context context, int layoutResourceId, List<ImageItem> data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

