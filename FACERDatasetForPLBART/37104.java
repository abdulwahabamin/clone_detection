    /**
     * �?存 Serializable数�?� 到 缓存中
     *
     * @param key   �?存的key
     * @param value �?存的value
     */
    public void put(String key, Serializable value) {
        put(key, value, -1);
    }

