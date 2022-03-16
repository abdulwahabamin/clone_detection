    public static void setTranslationX(View view, float translationX) {
        if (NEEDS_PROXY) {
            wrap(view).setTranslationX(translationX);
        } else {
            Honeycomb.setTranslationX(view, translationX);
        }
    }

