    private void initPaintTools() {

        mSatValPaint = new Paint();
        mSatValTrackerPaint = new Paint();
        mHuePaint = new Paint();
        mHueTrackerPaint = new Paint();
        mAlphaPaint = new Paint();
        mAlphaTextPaint = new Paint();
        mBorderPaint = new Paint();


        mSatValTrackerPaint.setStyle(Style.STROKE);
        mSatValTrackerPaint.setStrokeWidth(2f * mDensity);
        mSatValTrackerPaint.setAntiAlias(true);

        mHueTrackerPaint.setColor(mSliderTrackerColor);
        mHueTrackerPaint.setStyle(Style.STROKE);
        mHueTrackerPaint.setStrokeWidth(2f * mDensity);
        mHueTrackerPaint.setAntiAlias(true);

        mAlphaTextPaint.setColor(0xff1c1c1c);
        mAlphaTextPaint.setTextSize(14f * mDensity);
        mAlphaTextPaint.setAntiAlias(true);
        mAlphaTextPaint.setTextAlign(Align.CENTER);
        mAlphaTextPaint.setFakeBoldText(true);


    }

