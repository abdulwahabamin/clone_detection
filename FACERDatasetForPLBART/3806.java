    public static void setPivotX(View view, float pivotX) {
        if (NEEDS_PROXY) {
            wrap(view).setPivotX(pivotX);
        } else {
            Honeycomb.setPivotX(view, pivotX);
        }
    }

