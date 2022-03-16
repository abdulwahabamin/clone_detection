    private void init() {

        //画笔�?始化：
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setFilterBitmap(true);
        mPaint.setDither(true);
        mPaint.setColor(ContextCompat.getColor(MyApplication.getAppContext(),R.color.maincolor));
        String familyName ="宋体";
        Typeface font = Typeface.create(familyName,Typeface.BOLD);
        mPaint.setTypeface(font);
        mPaint.setTextSize(DisplayUtil.sp2px(MyApplication.getAppContext(),50));
        mPaint.setTextAlign(Paint.Align.CENTER);

        //背部图片的�?始化
        backBitmap = getDescBitmap();
        int mBitH = backBitmap.getHeight();
        int mBitW = backBitmap.getWidth();
        bPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bPaint.setFilterBitmap(true);
        bPaint.setDither(true);
        bPaint.setColor(ContextCompat.getColor(MyApplication.getAppContext(),R.color.white));

        //设置当�?的高度
        mCurTop = mBitH / 2 ;
        mCurBelow = mCurTop;

        int topRectH = mCurTop;
        int belowRectH = mCurBelow;
        topRect = new Rect(0,
                           topRectH,
                           mBitW,
                           topRectH);  //�?始化原图

        belowRect = new Rect(0,
                             belowRectH ,
                             mBitW,
                             belowRectH);
    }

