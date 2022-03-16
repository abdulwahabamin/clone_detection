    /**
     * ä¿?å­˜ Stringæ•°æ?® åˆ° ç¼“å­˜ä¸­
     *
     * @param key
     *            ä¿?å­˜çš„key
     * @param value
     *            ä¿?å­˜çš„Stringæ•°æ?®
     * @param saveTime
     *            ä¿?å­˜çš„æ—¶é—´ï¼Œå?•ä½?ï¼šç§’
     */
    public void put(String key, String value, int saveTime) {
        put(key, Utils.newStringWithDateInfo(saveTime, value));
    }

