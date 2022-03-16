    /**
     * SP中读�?�String
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，�?存在返回默认值{@code defaultValue}
     */
    public String getString(@NonNull final String key, @NonNull final String defaultValue) {
        return sp.getString(key, defaultValue);
    }

