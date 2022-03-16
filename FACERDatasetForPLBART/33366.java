    CityUtilitiesCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to,
                               int flags, OnClickListener onClickListener) {
        super(context, layout, c, from, to, flags, onClickListener);
        listener = (Listener) context;
        isRemovalModeButton = SharedPrefsHelper.isRemovalModeButton(context);
    }

