    public static int getBodyColor(Palette.Swatch swatch) {
        if (swatch == null) {
            return BODY_COLOR_FALLBACK;
        }

        if (isColorDark(swatch.getRgb())) {
            return BODY_COLOR_LIGHT;
        } else {
            return BODY_COLOR_DARK;
        }
    }

