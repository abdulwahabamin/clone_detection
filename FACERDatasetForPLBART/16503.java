    /**
     * SP中读�?�long
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，�?存在返回默认值{@code defaultValue}
     */
    public long getLong(@NonNull final String key, final long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

