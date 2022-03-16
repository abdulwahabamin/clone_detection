    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        if (mDragState != IDLE) {
            // draw the divider over the expanded item
            if (mFirstExpPos != mSrcPos) {
                drawDivider(mFirstExpPos, canvas);
            }
            if (mSecondExpPos != mFirstExpPos && mSecondExpPos != mSrcPos) {
                drawDivider(mSecondExpPos, canvas);
            }
        }

        if (mFloatView != null) {
            // draw the float view over everything
            final int floatViewWidth = mFloatView.getWidth();
            final int floatViewHeight = mFloatView.getHeight();

            int x = mFloatLoc.x;

            final int listViewWidth = getWidth();
            if (x < 0)
                x = -x;
            float alphaMod;
            if (x < listViewWidth) {
                alphaMod = ((float) (listViewWidth - x)) / ((float) listViewWidth);
                alphaMod *= alphaMod;
            } else {
                alphaMod = 0;
            }

            final int alpha = (int) (255f * mCurrFloatAlpha * alphaMod);

            canvas.save();
            canvas.translate(mFloatLoc.x, mFloatLoc.y);
            canvas.clipRect(0, 0, floatViewWidth, floatViewHeight);

            canvas.saveLayerAlpha(0, 0, floatViewWidth, floatViewHeight, alpha, 
                    Canvas.ALL_SAVE_FLAG);

            mFloatView.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

