    /**
     * SP中读�?�long
     *
     * @param key 键
     * @return 存在返回对应值，�?存在返回默认值-1
     */
    public long getLong(@NonNull final String key) {
        return getLong(key, -1L);
    }

