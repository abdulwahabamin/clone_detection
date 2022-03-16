    public static int getTitleColor(Palette.Swatch swatch) {
        if (swatch == null) {
            return TITLE_COLOR_FALLBACK;
        }
        if (isColorDark(swatch.getRgb())) {
            return TITLE_COLOR_LIGHT;
        } else {
            return TITLE_COLOR_DARK;
        }
    }

