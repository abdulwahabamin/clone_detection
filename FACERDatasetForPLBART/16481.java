    /**
     * px转dp
     */
    public static float px2dp(float pxVal) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

