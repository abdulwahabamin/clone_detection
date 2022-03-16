    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //当设置的padding值�?于默认值是设置为默认值
        paddingT = DisplayUtil.dp2px(mContext, 20);
        paddingL = DisplayUtil.dp2px(mContext, 10);
        paddingR = DisplayUtil.dp2px(mContext, 15);
        paddingB = Math.max(paddingB, getPaddingBottom());

        //获�?�测�?模�?
        //注�? HorizontalScrollView的�?View 在没有明确指定dp值的情况下 widthMode总是MeasureSpec.UNSPECIFIED
        //�?��?� ScrollView的�?View的heightMode
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //获�?�测�?大�?
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize + paddingL + paddingR;
            mHeight = heightSize;
        }

        //如果为wrap_content 那么View大�?为默认值
        if (widthMode == MeasureSpec.UNSPECIFIED && heightMode == MeasureSpec.AT_MOST) {
            mWidth = defWidthPixel + paddingL + paddingR;
            mHeight = defHeightPixel + paddingT + paddingB;
        }

        //设置视图的大�?
        setMeasuredDimension(mWidth, mHeight);

    }

