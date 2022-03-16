    private int getPrefferedWidth() {

        int width = getPreferedHeight();

        if (mShowAlphaPanel) {
            width -= (PANEL_SPACING + ALPHA_PANEL_HEIGHT);
        }


        return (int) (width + HUE_PANEL_WIDTH + PANEL_SPACING);

    }

