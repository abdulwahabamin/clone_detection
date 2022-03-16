    /**
     * px转sp
     */
    public static float px2sp(float pxVal) {
        return (pxVal / AppUtils.getContext().getResources().getDisplayMetrics().scaledDensity);
    }

