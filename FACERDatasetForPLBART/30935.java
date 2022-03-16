    private MemoryCacheManager() {
        // �?�本虚拟机�?�用的最大内存的1/16作为内存缓存区
        int maxMemorySize = (int)Runtime.getRuntime().maxMemory();
        int maxCacheSize = maxMemorySize >> 4;
        mMemoryLruCache = new LruCache<String, T>(maxCacheSize) {
            @Override
            protected int sizeOf(String key, T value) {
                return value.getSize();
            }

            @Override
            protected void entryRemoved(boolean evicted, String key,
                                        T oldValue, T newValue) {
                if (oldValue != null)
                    oldValue.release();
            }
        };
    }

