    /**
     * �?存 bitmap 到 缓存中
     *
     * @param key
     *            �?存的key
     * @param value
     *            �?存的 bitmap 数�?�
     * @param saveTime
     *            �?存的时间，�?��?：秒
     */
    public void put(String key, Bitmap value, int saveTime) {
        put(key, Utils.Bitmap2Bytes(value), saveTime);
    }

