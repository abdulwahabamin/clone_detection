    public static void setScaleY(View view, float scaleY) {
        if (NEEDS_PROXY) {
            wrap(view).setScaleY(scaleY);
        } else {
            Honeycomb.setScaleY(view, scaleY);
        }
    }

