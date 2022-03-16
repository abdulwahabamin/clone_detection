    /**
     * SP中读�?�boolean
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，�?存在返回默认值{@code defaultValue}
     */
    public boolean getBoolean(@NonNull final String key, final boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

