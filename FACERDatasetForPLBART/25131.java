    private void postConstruct(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.RhythmTextView);
        setTypeface(RalewayFont.getInstance(context.getApplicationContext())
                .getTypeFace(typedArray.getString(R.styleable.RhythmTextView_textType)));
        typedArray.recycle();
    }

