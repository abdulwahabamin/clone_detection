    private void setUpSatValRect() {

        final RectF    dRect = mDrawingRect;
        float panelSide = dRect.height() - BORDER_WIDTH_PX * 2;

        if (mShowAlphaPanel) {
            panelSide -= PANEL_SPACING + ALPHA_PANEL_HEIGHT;
        }

        float left = dRect.left + BORDER_WIDTH_PX;
        float top = dRect.top + BORDER_WIDTH_PX;
        float bottom = top + panelSide;
        float right = left + panelSide;

        mSatValRect = new RectF(left,top, right, bottom);
    }

