    public TextShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCurW = ScreenUtil.getScreenW(context);
        mCurH = ScreenUtil.getScreenH(context);
        height = mCurH;
        width = mCurW;
        init();
    }

