    /**
     * �?存 JSONArray数�?� 到 缓存中
     *
     * @param key   �?存的key
     * @param value �?存的JSONArray数�?�
     */
    public void put(String key, JSONArray value) {
        put(key, value.toString());
    }

