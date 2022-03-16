    public static void setScaleX(View view, float scaleX) {
        if (NEEDS_PROXY) {
            wrap(view).setScaleX(scaleX);
        } else {
            Honeycomb.setScaleX(view, scaleX);
        }
    }

