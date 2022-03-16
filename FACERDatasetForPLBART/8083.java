    private void setUpColorRect() {
        final RectF    dRect = mDrawingRect;

        float left = dRect.left + BORDER_WIDTH_PX;
        float top = dRect.top + BORDER_WIDTH_PX;
        float bottom = dRect.bottom - BORDER_WIDTH_PX;
        float right = dRect.right - BORDER_WIDTH_PX;

        mColorRect = new RectF(left,top, right, bottom);

        mAlphaPattern = new AlphaPatternDrawable((int)(5 * mDensity));

        mAlphaPattern.setBounds(Math.round(mColorRect.left),
                Math.round(mColorRect.top),
                Math.round(mColorRect.right),
                Math.round(mColorRect.bottom));

    }

