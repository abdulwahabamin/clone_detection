    /**
     * This method converts device specific pixels to device independent pixels.
     *
     * @param ctx The current context
     * @param px A value in px (pixels) unit
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(Context ctx, float px) {
        Resources resources = ctx.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / (metrics.densityDpi / 160f);

    }

