    private void drawAlphaPanel(Canvas canvas) {

        if (!mShowAlphaPanel || mAlphaRect == null || mAlphaPattern == null) return;

        final RectF rect = mAlphaRect;

        if (BORDER_WIDTH_PX > 0) {
            mBorderPaint.setColor(mBorderColor);
            canvas.drawRect(rect.left - BORDER_WIDTH_PX,
                    rect.top - BORDER_WIDTH_PX,
                    rect.right + BORDER_WIDTH_PX,
                    rect.bottom + BORDER_WIDTH_PX,
                    mBorderPaint);
        }


        mAlphaPattern.draw(canvas);

        float[] hsv = new float[]{mHue,mSat,mVal};
        int color = Color.HSVToColor(hsv);
        int acolor = Color.HSVToColor(0, hsv);

        mAlphaShader = new LinearGradient(rect.left, rect.top, rect.right, rect.top,
                color, acolor, TileMode.CLAMP);


        mAlphaPaint.setShader(mAlphaShader);

        canvas.drawRect(rect, mAlphaPaint);

        if (mAlphaSliderText != null && mAlphaSliderText!= "") {
            canvas.drawText(mAlphaSliderText, rect.centerX(), rect.centerY() + 4 * mDensity, mAlphaTextPaint);
        }

        float rectWidth = 4 * mDensity / 2;

        Point p = alphaToPoint(mAlpha);

        RectF r = new RectF();
        r.left = p.x - rectWidth;
        r.right = p.x + rectWidth;
        r.top = rect.top - RECTANGLE_TRACKER_OFFSET;
        r.bottom = rect.bottom + RECTANGLE_TRACKER_OFFSET;

        canvas.drawRoundRect(r, 2, 2, mHueTrackerPaint);

    }

