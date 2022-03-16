    private void init() {
        mWidth = getMeasuredWidth();
        mGradientPaint = new Paint();
        mGradientPaint.setAntiAlias(true);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextSize = UIUtil.dipToPx(getContext(), 10.0f);
        mTextPaint.setTextSize(mTextSize);

        mPaintStroke = UIUtil.dipToPx(getContext(), 4.0f);
        mPaddingTop = mPaintStroke;

        mRectLeft = new RectF(0, mPaddingTop - mPaintStroke / 2, mPaintStroke, mPaintStroke + mPaddingTop - mPaintStroke / 2);
        mRectRight = new RectF(mWidth - mPaintStroke, mPaddingTop - mPaintStroke / 2, mWidth, mPaintStroke + mPaddingTop - mPaintStroke / 2);

        mGradientPaint.setStyle(Paint.Style.FILL);
    }

