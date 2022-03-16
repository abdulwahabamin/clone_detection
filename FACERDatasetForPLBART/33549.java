    /**
     * Obtains or creates a new memory cache to store the weather icons.
     */
    private void setIconMemoryCache() {
        IconCacheRetainFragment retainFragment =
                IconCacheRetainFragment.findOrCreateRetainFragment(getSupportFragmentManager());
        iconCache = retainFragment.iconCache;
        if (iconCache == null) {
            // maximum available VM memory, stored in kilobytes
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            // we use 1/8th of the available memory for this memory cache
            int cacheSize = maxMemory / 8;

            iconCache = new LruCache<String, Bitmap>(cacheSize) {

                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    // the cache size will be measured in kilobytes rather than number of items
                    return bitmap.getByteCount() / 1024;
                }
            };

        }
        retainFragment.iconCache = iconCache;
    }

