    /**
     * å°†pxå€¼è½¬æ?¢ä¸ºspå€¼ï¼Œä¿?è¯?æ–‡å­—å¤§å°?ä¸?å?˜
     *
     * @param pxValue
     *            ï¼ˆDisplayMetricsç±»ä¸­å±žæ€§scaledDensityï¼‰
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

