    private void init(Context context) {
        baseLinePaint = new Paint();
        baseLinePaint.setColor(ContextCompat.getColor(context, R.color.maincolor));
        baseLinePaint.setAntiAlias(true);
        baseLinePaint.setStyle(Paint.Style.FILL);
        baseLinePaint.setStrokeWidth(10);

        verticalLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        verticalLinePaint.setStyle(Paint.Style.STROKE);
        verticalLinePaint.setColor(ContextCompat.getColor(context, R.color.lightgray));
        verticalLinePaint.setAntiAlias(true);
        verticalLinePaint.setStrokeWidth(5);
        verticalLinePaint.setStrokeCap(Paint.Cap.ROUND);
        PathEffect effect = new DashPathEffect(new float[]{1, 2, 4, 8}, 1);
        verticalLinePaint.setPathEffect(effect);
        verticalLinePaint.setStrokeJoin(Paint.Join.ROUND);

        highPointPaint = new Paint();
        highPointPaint.setColor(ContextCompat.getColor(context, R.color.red));
        highPointPaint.setAntiAlias(true);
        highPointPaint.setStyle(Paint.Style.STROKE);
        highPointPaint.setStrokeWidth(5);

        lowPointPaint = new Paint();
        lowPointPaint.setColor(ContextCompat.getColor(context, R.color.maincolor));
        lowPointPaint.setAntiAlias(true);
        lowPointPaint.setStyle(Paint.Style.STROKE);
        lowPointPaint.setStrokeWidth(5);

        highLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        highLinePaint.setColor(ContextCompat.getColor(context, R.color.red));
        highLinePaint.setAntiAlias(true);
        highLinePaint.setStrokeWidth(5);
        highLinePaint.setStrokeCap(Paint.Cap.ROUND);
        highLinePaint.setStrokeJoin(Paint.Join.ROUND);
        highLinePaint.setStyle(Paint.Style.STROKE);

        lowLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        lowLinePaint.setColor(ContextCompat.getColor(context, R.color.cadetblue));
        lowLinePaint.setAntiAlias(true);
        lowLinePaint.setStrokeWidth(5);
        lowLinePaint.setStrokeCap(Paint.Cap.ROUND);
        lowLinePaint.setStrokeJoin(Paint.Join.ROUND);
        lowLinePaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
        dPath = new Path();

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(ContextCompat.getColor(context, R.color.black));
        String familyName = "宋体";
        Typeface font = Typeface.create(familyName, Typeface.BOLD);
        textPaint.setTypeface(font);
        textPaint.setTextAlign(Paint.Align.CENTER);

        lowTempPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        lowTempPaint.setColor(ContextCompat.getColor(context, R.color.cadetblue));
        lowTempPaint.setTypeface(font);
        lowTempPaint.setTextAlign(Paint.Align.CENTER);

        highTempPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        highTempPaint.setColor(ContextCompat.getColor(context, R.color.red));
        highTempPaint.setTypeface(font);
        highTempPaint.setTextAlign(Paint.Align.CENTER);
    }

