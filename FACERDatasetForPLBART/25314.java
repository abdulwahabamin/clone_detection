    public static LRUCache getInstance() {
        if (lruCache == null) {
            lruCache = new LRUCache();
        }

        return lruCache;
    }

