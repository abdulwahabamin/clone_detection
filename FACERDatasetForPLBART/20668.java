    public static void setRotation(View view, float rotation) {
        if (NEEDS_PROXY) {
            wrap(view).setRotation(rotation);
        } else {
            Honeycomb.setRotation(view, rotation);
        }
    }

