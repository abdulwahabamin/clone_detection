    public AppThemeListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray colors = context.getResources().obtainTypedArray(R.array.pref_color_values);
        resourceIds = new int[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            resourceIds[i] = colors.getColor(i, DEFAULT_COLOUR_VALUE);
        }

        colors.recycle();
    }

