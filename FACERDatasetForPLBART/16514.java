    /**
     * SP中读�?�StringSet
     *
     * @param key 键
     * @return 存在返回对应值，�?存在返回默认值{@code Collections.<String>emptySet()}
     */
    public Set<String> getStringSet(@NonNull final String key) {
        return getStringSet(key, Collections.<String>emptySet());
    }

