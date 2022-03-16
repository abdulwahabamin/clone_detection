    private DataSourceManager(Context context) {
        if (null == context)
            throw new IllegalArgumentException("context cannot be null");

        mContext = context;
        mDiskCacheManager = new DiskCacheManager(context, DATA_CACHE_DIR);
        mServiceManager = ServicesManager.getInstance();
    }

