    /**
     * �?存 JSONObject数�?� 到 缓存中
     *
     * @param key
     *            �?存的key
     * @param value
     *            �?存的JSON数�?�
     */
    public void put(String key, JSONObject value) {
        put(key, value.toString());
    }

