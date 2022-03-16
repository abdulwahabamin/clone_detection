    public T getItemFromCache(final String key) {
        if (mMemoryLruCache != null) {
            return mMemoryLruCache.get(key);
        }

        return null;
    }

