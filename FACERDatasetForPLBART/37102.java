    /**
     * ä¿?å­˜ byteæ•°æ?® åˆ° ç¼“å­˜ä¸­
     *
     * @param key      ä¿?å­˜çš„key
     * @param value    ä¿?å­˜çš„æ•°æ?®
     * @param saveTime ä¿?å­˜çš„æ—¶é—´ï¼Œå?•ä½?ï¼šç§’
     */
    public void put(String key, byte[] value, int saveTime) {
        put(key, Utils.newByteArrayWithDateInfo(saveTime, value));
    }

