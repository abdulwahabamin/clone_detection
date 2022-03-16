    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (Check.isEmpty(mLevelColors)) {
            return;
        }

        mGradientPaint.setColor(mLevelColors.get(0).color);
        canvas.drawArc(mRectLeft, 90, 180, true, mGradientPaint);

        float widthIndex = mPaintStroke / 2;
        mGradientPaint.setStrokeWidth(mPaintStroke);
        float perGap = (mWidth - mPaintStroke) * 1.0f / mLevelColors.get(mLevelCount - 1).levelNumber;
        int lastNumber = 0;
        String text = "0";
        canvas.drawText(text, 0, mPaddingTop + mPaintStroke + mTextSize, mTextPaint);

        float cursorCenter = widthIndex + mCurrentValue * perGap;

        for (int index = 0; index < mLevelCount; index++) {

            LevelColorPair levelColorPair = mLevelColors.get(index);
            mGradientPaint.setColor(levelColorPair.color);

            float perLength = perGap * (levelColorPair.levelNumber - lastNumber);
            canvas.drawLine(widthIndex, mPaddingTop, widthIndex + perLength, mPaddingTop, mGradientPaint);

            widthIndex += perLength;
            lastNumber = levelColorPair.levelNumber;

            if (index == mLevelCount - 1) {
                text = "+";
            } else {
                text = levelColorPair.levelNumber + "";
            }
            canvas.drawText(text, widthIndex - mTextSize / 2, mPaddingTop + mPaintStroke + mTextSize, mTextPaint);
        }
        canvas.drawArc(mRectRight, 270, 180, true, mGradientPaint);

        mGradientPaint.setColor(UIUtil.getColor(getContext(), R.color.colorAccent));
        canvas.drawCircle(cursorCenter, mPaddingTop, mPaintStroke, mGradientPaint);

    }

