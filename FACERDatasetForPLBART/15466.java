    public ListViewAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        mContext = context;
        // Helps center the text in the Playlist/Genre tab
        left = mContext.getResources().getDimensionPixelSize(
                R.dimen.listview_items_padding_left_top);
        top = mContext.getResources().getDimensionPixelSize(
                R.dimen.listview_items_padding_gp_top);
        
    	mImageProvider = ImageProvider.getInstance( (Activity) mContext );
    }

