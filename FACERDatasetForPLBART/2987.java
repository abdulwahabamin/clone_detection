    /**
     * ä¿?å­˜ bitmap åˆ° ç¼“å­˜ä¸­
     *
     * @param key
     *            ä¿?å­˜çš„key
     * @param value
     *            ä¿?å­˜çš„ bitmap æ•°æ?®
     * @param saveTime
     *            ä¿?å­˜çš„æ—¶é—´ï¼Œå?•ä½?ï¼šç§’
     */
    public void put(String key, Bitmap value, int saveTime) {
        put(key, Utils.Bitmap2Bytes(value), saveTime);
    }

