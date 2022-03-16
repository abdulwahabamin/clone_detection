    public static MemoryCacheManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new MemoryCacheManager();
        }
        return ourInstance;
    }

