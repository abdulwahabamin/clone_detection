    /**
     * å°†spå€¼è½¬æ?¢ä¸ºpxå€¼ï¼Œä¿?è¯?æ–‡å­—å¤§å°?ä¸?å?˜
     *
     * @param spValue
     *            ï¼ˆDisplayMetricsç±»ä¸­å±žæ€§scaledDensityï¼‰
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

