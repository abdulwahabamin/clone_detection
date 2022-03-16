    public VelocityLinePageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (isInEditMode()) return;

        final Resources res = getResources();

        //Load defaults from resources
        final int defaultSelectedColor = res.getColor(R.color.default_line_indicator_selected_color);
        final int defaultUnselectedColor = res.getColor(R.color.default_line_indicator_unselected_color);
        final float defaultLineWidth = res.getDimension(R.dimen.default_line_indicator_line_width);
        final float defaultGapWidth = res.getDimension(R.dimen.default_line_indicator_gap_width);
        final float defaultStrokeWidth = res.getDimension(R.dimen.default_line_indicator_stroke_width);
        final boolean defaultCentered = res.getBoolean(R.bool.default_line_indicator_centered);

        //Retrieve styles attributes
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.VelocityLinePageIndicator, defStyle, 0);

        mCentered = a.getBoolean(R.styleable.VelocityLinePageIndicator_centered, defaultCentered);
        mLineWidth = a.getDimension(R.styleable.VelocityLinePageIndicator_lineWidth, defaultLineWidth);
        mGapWidth = a.getDimension(R.styleable.VelocityLinePageIndicator_gapWidth, defaultGapWidth);
        setStrokeWidth(a.getDimension(R.styleable.VelocityLinePageIndicator_strokeWidth, defaultStrokeWidth));
        mPaintUnselected.setColor(a.getColor(R.styleable.VelocityLinePageIndicator_unselectedColor, defaultUnselectedColor));
        mPaintSelected.setColor(a.getColor(R.styleable.VelocityLinePageIndicator_selectedColor, defaultSelectedColor));

        Drawable background = a.getDrawable(R.styleable.VelocityLinePageIndicator_android_background);
        if (background != null) {
          setBackgroundDrawable(background);
        }

        a.recycle();

        final ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
    }

