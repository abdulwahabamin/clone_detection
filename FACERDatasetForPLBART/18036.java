    public static int getBackgroundColor(Palette.Swatch swatch) {
        if (swatch == null) {
            return BACKGROUND_COLOR_FALLBACK;
        }

        return swatch.getRgb();
    }

