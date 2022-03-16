    /**
     * ã‚³ãƒ³ã‚¹ãƒˆãƒ©ã‚¯ã‚¿
     * android:backgroundã?®ãƒ‡ãƒ¼ã‚¿ã‚’å?–å¾—ã?—ãƒœã‚¿ãƒ³ã?®è‰²ã?¨ã?™ã‚‹
     * {@inheritDoc}
     */
    public PlayPauseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPoint = new Point();
        initView();
    }

