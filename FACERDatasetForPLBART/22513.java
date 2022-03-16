    public TimelyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimelyView);
        textColor = typedArray.getColor(R.styleable.TimelyView_text_color, Color.BLACK);
        init();
    }

