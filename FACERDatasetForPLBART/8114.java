    private int getPreferedHeight() {

        int height = (int)(200 * mDensity);

        if (mShowAlphaPanel) {
            height += PANEL_SPACING + ALPHA_PANEL_HEIGHT;
        }

        return height;
    }

