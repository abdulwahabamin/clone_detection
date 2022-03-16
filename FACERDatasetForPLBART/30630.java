    /**
     * 绘制太阳的�?置
     */
    private void drawSunPosition(Canvas canvas) {
//        canvas.drawRect(positionX + DisplayUtil.dp2px(mContext, 10), marginTop, mWidth / 2 + mRadius, mRadius * 2 + marginTop, mShadePaint);
        canvas.drawArc(mRectF, 180, 180, true, mPathPaint);

        canvas.drawBitmap(mSunIcon, positionX, positionY, mLinePaint);
    }

