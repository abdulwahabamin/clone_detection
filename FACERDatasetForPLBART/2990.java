    /**
     * ä¿?å­˜ drawable åˆ° ç¼“å­˜ä¸­
     *
     * @param key
     *            ä¿?å­˜çš„key
     * @param value
     *            ä¿?å­˜çš„ drawable æ•°æ?®
     * @param saveTime
     *            ä¿?å­˜çš„æ—¶é—´ï¼Œå?•ä½?ï¼šç§’
     */
    public void put(String key, Drawable value, int saveTime) {
        put(key, Utils.drawable2Bitmap(value), saveTime);
    }

