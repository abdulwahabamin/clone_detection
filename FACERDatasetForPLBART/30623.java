    private void initView(Context context, @Nullable AttributeSet attrs) {
        mContext = context;
        marginTop = DisplayUtil.dip2px(context, 30);
        @SuppressLint("CustomViewStyleable") TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.SunAnimationView);
        mCircleColor = type.getColor(R.styleable.SunAnimationView_sun_circle_color, getContext().getResources().getColor(R.color.dark_text_color));
        mFontColor = type.getColor(R.styleable.SunAnimationView_sun_font_color, getContext().getResources().getColor(R.color.colorAccent));
        mRadius = type.getInteger(R.styleable.SunAnimationView_sun_circle_radius, DisplayUtil.dp2px(getContext(), 130));
        mRadius = DisplayUtil.dp2px(getContext(), mRadius);
        mFontSize = type.getDimension(R.styleable.SunAnimationView_sun_font_size, DisplayUtil.dp2px(getContext(), 10));
        mFontSize = DisplayUtil.dp2px(getContext(), mFontSize);

        isSun = type.getBoolean(R.styleable.SunAnimationView_type, true);
        type.recycle();

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTimePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        shadePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

