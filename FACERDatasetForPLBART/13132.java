    @Override
    protected void onDraw(Canvas canvas) {
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();

        //Draw the relevance
        canvas.drawRect(0, 0, (this.mRelevance * w / 100), h, this.mRelevancePaint);

        //Draw the border
        canvas.drawLine(0, 0, w, 0, this.mBorderPaint);
        canvas.drawLine(w, 0, w, h, this.mBorderPaint);
        canvas.drawLine(w, h, 0, h, this.mBorderPaint);
        canvas.drawLine(0, h, 0, 0, this.mBorderPaint);
    }

