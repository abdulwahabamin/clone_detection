    @Override
    public void onDraw(Canvas canvas) {
        //canvas.drawRect(0, 0, getWidth() - 1, getHeight() - 1, backgroundPaint);
        if (this.getDrawable() != null) {
            //canvas.save();
            canvas.translate(mPosX, mPosY);

            matrix.reset();



            matrix.postScale(mScaleFactor, mScaleFactor, pivotPointX, pivotPointY);
            fixTrans();
            //matrix.postScale(mScaleFactor, mScaleFactor, getWidth() / mScaleFactor, getHeight() / mScaleFactor);
            // canvas.setMatrix(matrix);
            //BLog.e("START --- SF: " + mScaleFactor + ", PPX: " + pivotPointX + ", PPY: " + pivotPointY);
            try{
                canvas.drawBitmap(
                        ((BitmapDrawable) this.getDrawable()).getBitmap(), matrix,  null);
            } catch (Exception e) {}
            // this.getDrawable().draw(canvas);
            //canvas.restore();
        }
    }

