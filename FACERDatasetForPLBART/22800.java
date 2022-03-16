    public DividerItemDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        if (PreferencesUtility.getInstance(context).getTheme().equals("light"))
            mDivider = ContextCompat.getDrawable(context, R.drawable.item_divider_black);
        else mDivider = ContextCompat.getDrawable(context, R.drawable.item_divider_white);
//        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

