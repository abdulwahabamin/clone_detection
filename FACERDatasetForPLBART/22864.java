    /**
     * コンストラクタ
     * android:background�?�データを�?�得�?�ボタン�?�色�?��?�る
     * {@inheritDoc}
     */
    public PlayPauseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPoint = new Point();
        initView();
    }

