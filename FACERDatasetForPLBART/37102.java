    /**
     * �?存 byte数�?� 到 缓存中
     *
     * @param key      �?存的key
     * @param value    �?存的数�?�
     * @param saveTime �?存的时间，�?��?：秒
     */
    public void put(String key, byte[] value, int saveTime) {
        put(key, Utils.newByteArrayWithDateInfo(saveTime, value));
    }

