    /**
     * �?存 JSONObject数�?� 到 缓存中
     *
     * @param key
     *            �?存的key
     * @param value
     *            �?存的JSONObject数�?�
     * @param saveTime
     *            �?存的时间，�?��?：秒
     */
    public void put(String key, JSONObject value, int saveTime) {
        put(key, value.toString(), saveTime);
    }

