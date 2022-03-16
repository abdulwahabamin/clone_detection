    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        // �?�?��?�罩的画笔
        shadePaint.setColor(mContext.getResources().getColor(R.color.back_white));

        shadePaint.setStyle(Paint.Style.FILL);
        mShadePaint = shadePaint;

        pathPaint.setColor(mContext.getResources().getColor(R.color.attention_text_light));
        if (isSun) {
            mSunIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_sun);
        } else {
            mSunIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_moon);
        }
        mSunIcon = DisplayUtil.bitmapResize(mSunIcon, DisplayUtil.dp2px(mContext, 18), DisplayUtil.dp2px(mContext, 18));
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setStrokeWidth(2);
        mPathPaint = pathPaint;
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setDither(true);//防止抖动
        mLinePaint.setStrokeWidth(2);
        //第一步：画�?�圆
        drawSemicircle(canvas);
        canvas.save();

        mLinePaint.setColor(mContext.getResources().getColor(R.color.attention_text_light));
        canvas.drawLine(mWidth / 2 - mRadius - DisplayUtil.dip2px(mContext, 10), mRadius + marginTop, mWidth / 2 + mRadius + DisplayUtil.dip2px(mContext, 10), mRadius + marginTop, mLinePaint);
        //第二步：绘制太阳的�?始�?置 以�?� �?��?�在动画中�?断的更新太阳的X，Y�??标�?�改�?�太阳图片在视图中的显示
        //第三部：绘制图上的文字
        drawSunPosition(canvas);
        drawFont(canvas);

        super.onDraw(canvas);
    }

