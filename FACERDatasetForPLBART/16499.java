    /**
     * SP中读�?�int
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，�?存在返回默认值{@code defaultValue}
     */
    public int getInt(@NonNull final String key, final int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

