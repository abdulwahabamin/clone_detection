    public GenreAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        // Helps center the text in the Genres tab
        mContext = context;
        left = mContext.getResources().getDimensionPixelSize(
                R.dimen.listview_items_padding_left_top);
    }

