    /**
     * 绘制�?�圆
     */
    private void drawSemicircle(Canvas canvas) {
        mRectF = new RectF(mWidth / 2 - mRadius, marginTop, mWidth / 2 + mRadius, mRadius * 2 + marginTop);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setDither(true);//防止抖动
        mTextPaint.setColor(mCircleColor);
        canvas.drawArc(mRectF, 180, 180, true, mTextPaint);
    }

