    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayerCount = canvas.saveLayer(0, 0, mCurW, mCurH, bPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(backBitmap, 0, 0, bPaint);// 绘制目标图
        bPaint.setXfermode(mXfermode);    //设置混排模�?
        canvas.drawRect(topRect, bPaint);   //绘制�?图
        canvas.drawRect(belowRect,bPaint);
        bPaint.setXfermode(null);         //清除混排模�?
        canvas.restoreToCount(saveLayerCount);    //�?��?�?存的图层

        // 改�?�Rect区域，�?�如
        mCurTop -= 1;
        mCurBelow += 1;
        topRect.top = mCurTop;
        belowRect.bottom = mCurBelow;
        if (mCurTop >= height / 2 - getPx(150)) {
            invalidate();
        }
    }

