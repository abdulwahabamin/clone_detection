    public <T> T get(String key) {

        MemoryItem<T> memoryItem = memoryCache.get(key);

        return (memoryItem != null) ? memoryItem.getItem() : null;
    }

