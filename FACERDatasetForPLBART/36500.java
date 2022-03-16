    private void initAttrs(Context context, @Nullable AttributeSet attrs) {

        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.defaultTitleTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, defaultTitleTextSize, dm);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleView);
        title = typedArray.getString(R.styleable.TitleView_titleViewText);
        titleTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleView_titleViewTextSize, defaultTitleTextSize);
        titleTextColor = typedArray.getColor(R.styleable.TitleView_titleViewTextColor, getResources().getColor(defaultTitleTextColorId));
        titleBackgroundColor = typedArray.getColor(R.styleable.TitleView_titleViewBackground, getResources().getColor(defaultTitleBackgroundColorId));
        titleLineColor = typedArray.getColor(R.styleable.TitleView_titleViewLineColor, getResources().getColor(defaultTitleLineColorId));
        typedArray.recycle();
    }

