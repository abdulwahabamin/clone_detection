    private void init(Context context){
        mTopTemp=new ArrayList<>();
        mTopTemp.add(12);
        mTopTemp.add(15);
        mTopTemp.add(11);
        mTopTemp.add(13);
        mTopTemp.add(19);
        mTopTemp.add(21);
        mTopTemp.add(16);
        mLowTemp=new ArrayList<>();
        mLowTemp.add(5);
        mLowTemp.add(6);
        mLowTemp.add(3);
        mLowTemp.add(8);
        mLowTemp.add(11);
        mLowTemp.add(9);
        mLowTemp.add(8);

        pxScale= DisplayUtil.pxScale(context);
        fontScale= DisplayUtil.fontScale(context);

        mPoint1Paint=new Paint();
        mPoint1Paint.setAntiAlias(true);
        mPoint1Paint.setColor(Color.argb(255,205,85,0));

        mPoint2Paint=new Paint();
        mPoint2Paint.setAntiAlias(true);
        mPoint2Paint.setColor(Color.argb(255,64,95,237));

        mLinePaint=new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStrokeWidth(5*pxScale/3);
        mLinePaint.setColor(Color.argb(255,239,239,239));

        mTextPaint=new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.argb(255,255,255,255));
        mTextPaint.setTextSize(40*fontScale/3);
        mTextPaint.setTypeface(Typeface.create("",Typeface.NORMAL));
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }

