    /**
     * �?存 String数�?� 到 缓存中
     *
     * @param key
     *            �?存的key
     * @param value
     *            �?存的String数�?�
     * @param saveTime
     *            �?存的时间，�?��?：秒
     */
    public void put(String key, String value, int saveTime) {
        put(key, Utils.newStringWithDateInfo(saveTime, value));
    }

