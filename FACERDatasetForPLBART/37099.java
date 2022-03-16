    /**
     * ä¿?å­˜ JSONArrayæ•°æ?® åˆ° ç¼“å­˜ä¸­
     *
     * @param key      ä¿?å­˜çš„key
     * @param value    ä¿?å­˜çš„JSONArrayæ•°æ?®
     * @param saveTime ä¿?å­˜çš„æ—¶é—´ï¼Œå?•ä½?ï¼šç§’
     */
    public void put(String key, JSONArray value, int saveTime) {
        put(key, value.toString(), saveTime);
    }

