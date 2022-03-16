    private void drawHuePanel(Canvas canvas) {

        final RectF rect = mHueRect;

        if (BORDER_WIDTH_PX > 0) {
            mBorderPaint.setColor(mBorderColor);
            canvas.drawRect(rect.left - BORDER_WIDTH_PX,
                    rect.top - BORDER_WIDTH_PX,
                    rect.right + BORDER_WIDTH_PX,
                    rect.bottom + BORDER_WIDTH_PX,
                    mBorderPaint);
        }

        if (mHueShader == null) {
            mHueShader = new LinearGradient(rect.left, rect.top, rect.left, rect.bottom, buildHueColorArray(), null, TileMode.CLAMP);
            mHuePaint.setShader(mHueShader);
        }

        canvas.drawRect(rect, mHuePaint);

        float rectHeight = 4 * mDensity / 2;

        Point p = hueToPoint(mHue);

        RectF r = new RectF();
        r.left = rect.left - RECTANGLE_TRACKER_OFFSET;
        r.right = rect.right + RECTANGLE_TRACKER_OFFSET;
        r.top = p.y - rectHeight;
        r.bottom = p.y + rectHeight;


        canvas.drawRoundRect(r, 2, 2, mHueTrackerPaint);

    }

