    private void initPaint() {
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//关闭硬件加速

        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(mContext.getResources().getColor(R.color.line_back_dark));
        paint1.setStyle(Paint.Style.FILL);

        foldLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        foldLinePaint.setStyle(Paint.Style.STROKE);
        foldLinePaint.setStrokeWidth(5);
        foldLinePaint.setColor(mContext.getResources().getColor(R.color.line_color));

        backPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backPaint.setStrokeWidth(2);
        backPaint.setAntiAlias(true);

        dashPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dashPaint.setColor(mContext.getResources().getColor(R.color.back_white));
        DashPathEffect pathEffect = new DashPathEffect(new float[]{8, 8, 8, 8}, 1);
        dashPaint.setPathEffect(pathEffect);
        dashPaint.setStrokeWidth(3);
        dashPaint.setAntiAlias(true);
        dashPaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(textSize);

        textLinePaint = new TextPaint();
        textLinePaint.setTextSize(DisplayUtil.sp2px(getContext(), 12));
        textLinePaint.setAntiAlias(true);

        textLinePaint.setColor(mContext.getResources().getColor(R.color.black));
        textPaint.setColor(mContext.getResources().getColor(R.color.search_light_un_color));

        baseLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        baseLinePaint.setStrokeWidth(3);
        baseLinePaint.setStyle(Paint.Style.STROKE);
        baseLinePaint.setColor(mContext.getResources().getColor(R.color.slategray));


        bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmapPaint.setFilterBitmap(true);//图�?滤波处�?�
        bitmapPaint.setDither(true);//防抖动
    }

