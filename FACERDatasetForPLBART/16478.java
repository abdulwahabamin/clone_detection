    /**
     * 根�?�手机的分辨率从 px(�?素) 的�?��? 转�?为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

