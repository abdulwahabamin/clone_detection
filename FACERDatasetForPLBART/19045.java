    /**
     * Returns a semitransparent color layer that can be used as
     * background for text that needs to be overlayed on an image.
     */
    public static int getSemiTransparentLayerColor(Context context) {
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            return 0xEE232323;
        } else {
            return 0xEEFFFFFF;
        }

    }

