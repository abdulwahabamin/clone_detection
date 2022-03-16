    public static void setPivotY(View view, float pivotY) {
        if (NEEDS_PROXY) {
            wrap(view).setPivotY(pivotY);
        } else {
            Honeycomb.setPivotY(view, pivotY);
        }
    }

