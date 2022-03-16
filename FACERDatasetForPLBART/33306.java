    BaseCityCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags,
                          OnClickListener onClickListener) {
        super(context, layout, c, from, to, flags);
        this.onClickListener = onClickListener;

        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.themed_clickable, outValue, true);
        BACKGROUND_RESOURCE_ODD = outValue.resourceId;
    }

