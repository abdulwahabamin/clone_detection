    public PlayTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PlayTransition);
        setColor(a.getColor(R.styleable.PlayTransition_colorCT, getColor()));
        a.recycle();
    }

