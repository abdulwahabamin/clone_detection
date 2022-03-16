    public void clearMemCache() {
        if (mLruCache != null) {
            mLruCache.evictAll();
        }
        System.gc();
    }

