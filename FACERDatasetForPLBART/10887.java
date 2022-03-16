    private void setUpAlphaRect() {

        if (!mShowAlphaPanel) return;

        final RectF    dRect = mDrawingRect;

        float left = dRect.left + BORDER_WIDTH_PX;
        float top = dRect.bottom - ALPHA_PANEL_HEIGHT + BORDER_WIDTH_PX;
        float bottom = dRect.bottom - BORDER_WIDTH_PX;
        float right = dRect.right - BORDER_WIDTH_PX;

        mAlphaRect = new RectF(left, top, right, bottom);


        mAlphaPattern = new AlphaPatternDrawable((int) (5 * mDensity));
        mAlphaPattern.setBounds(Math.round(mAlphaRect.left), Math
                .round(mAlphaRect.top), Math.round(mAlphaRect.right), Math
                .round(mAlphaRect.bottom));



    }

