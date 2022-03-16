    public ImageLoader(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(
                Context.ACTIVITY_SERVICE);
        mContext = context;
        mAppIcon = mContext.getDrawable(R.drawable.ic_launcher_icon);

        /*
         *  Get the heap size for our application in MB and compute a
         *  safe size for our image cache. Image cache sizze is in KB
         */
        int maxKb;
        try {
            maxKb = am.getMemoryClass() * 1024;
        } catch (Exception e) {
            maxKb = 1024 * 1024 * 3;
            Log.d(TAG, "ImageLoader() Unable to get heap size: " + e.getMessage());
        }
        int limitKb = (maxKb * CACHE_SIZE) / 100;
        Log.d(TAG, "ImageLoader() - Application heap size: " + maxKb + " KB");
        Log.d(TAG, "ImageLoader() - Image cache size: " + limitKb + " KB");
        cache = new ImageLruCache(limitKb);
        badArtwork = new LruCache<>(1000);
        mAsyncTaskCount = 0;
    }

