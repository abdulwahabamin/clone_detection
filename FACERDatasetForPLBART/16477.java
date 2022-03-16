    /**
     * æ ¹æ?®æ‰‹æœºçš„åˆ†è¾¨çŽ‡ä»Ž dip çš„å?•ä½? è½¬æˆ?ä¸º px(åƒ?ç´ )
     */
    public static int dip2px(float dpValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

