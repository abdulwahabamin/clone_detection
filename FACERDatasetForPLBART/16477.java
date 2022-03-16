    /**
     * 根�?�手机的分辨率从 dip 的�?��? 转�?为 px(�?素)
     */
    public static int dip2px(float dpValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

