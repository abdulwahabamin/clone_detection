    /**
     * æ ¹æ?®æ‰‹æœºçš„åˆ†è¾¨çŽ‡ä»Ž px(åƒ?ç´ ) çš„å?•ä½? è½¬æˆ?ä¸º dp
     */
    public static int px2dip(float pxValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

