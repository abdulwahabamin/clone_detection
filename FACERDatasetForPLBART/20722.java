    private void init(final Context context, final AttributeSet attrs)
    {
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleView);
        rippleColor = typedArray.getColor(R.styleable.RippleView_color, getResources().getColor(R.color.rippelColor));
        rippleType = typedArray.getInt(R.styleable.RippleView_type, 0);
        hasToZoom = typedArray.getBoolean(R.styleable.RippleView_zoom, false);
        isCentered = typedArray.getBoolean(R.styleable.RippleView_centered, false);
        DURATION = typedArray.getInteger(R.styleable.RippleView_rippleDuration, DURATION);
        FRAME_RATE = typedArray.getInteger(R.styleable.RippleView_framerate, FRAME_RATE);
        PAINT_ALPHA = typedArray.getInteger(R.styleable.RippleView_alpha, PAINT_ALPHA);
        ripplePadding = typedArray.getDimensionPixelSize(R.styleable.RippleView_ripplePadding, 0) * 2;
        canvasHandler = new Handler();
        scaleAnimation = AnimationUtils.loadAnimation(context, R.anim.zoom);
        scaleAnimation.setDuration(typedArray.getInteger(R.styleable.RippleView_zoomDuration, 150));
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(rippleColor);
        paint.setAlpha(PAINT_ALPHA);
        this.setWillNotDraw(false);

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e)
            {
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e)
            {
                return true;
            }
        });

        this.setDrawingCacheEnabled(true);
    }

