    /**
     * �?存 drawable 到 缓存中
     *
     * @param key
     *            �?存的key
     * @param value
     *            �?存的drawable数�?�
     */
    public void put(String key, Drawable value) {
        put(key, Utils.drawable2Bitmap(value));
    }

