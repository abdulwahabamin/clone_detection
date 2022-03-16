    public static Palette.Swatch getColorSwatch(@Nullable Palette palette) {
        if (palette != null) {
            if (palette.getMutedSwatch() != null) {
                return palette.getMutedSwatch();
            } else if (palette.getLightMutedSwatch() != null) {
                return palette.getLightMutedSwatch();
            } else if (palette.getDarkMutedSwatch() != null) {
                return palette.getDarkMutedSwatch();
            }
        }
        return null;
    }

