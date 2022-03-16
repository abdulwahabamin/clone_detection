    /**
     * �?存 bitmap 到 缓存中
     *
     * @param key   �?存的key
     * @param value �?存的bitmap数�?�
     */
    public void put(String key, Bitmap value) {
        put(key, Utils.Bitmap2Bytes(value));
    }

