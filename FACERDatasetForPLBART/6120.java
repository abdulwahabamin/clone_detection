    /**
     * �?存 drawable 到 缓存中
     *
     * @param key
     *            �?存的key
     * @param value
     *            �?存的 drawable 数�?�
     * @param saveTime
     *            �?存的时间，�?��?：秒
     */
    public void put(String key, Drawable value, int saveTime) {
        put(key, Utils.drawable2Bitmap(value), saveTime);
    }

