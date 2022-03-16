    public static void setAlpha(View view, float alpha) {
        if (NEEDS_PROXY) {
            wrap(view).setAlpha(alpha);
        } else {
            Honeycomb.setAlpha(view, alpha);
        }
    }

