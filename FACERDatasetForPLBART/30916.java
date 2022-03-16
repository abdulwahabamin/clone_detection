    public DiskCacheManager(Context context, String cacheDirName) {
        if (null == context || null == cacheDirName) {
            throw new IllegalArgumentException("arguments cannot be null");
        }
        this.mContext = context;
        this.mCacheDirName = cacheDirName;
        mJsonProcesser = new JsonProcesser();
        File cacheDir = FileUtil.getDiskCacheDir(mContext, mCacheDirName);
        if (!cacheDir.exists())
            cacheDir.mkdir();
        try {
            mDiskLruCache = DiskLruCache.open(cacheDir, PackageUtil.getAppVersion(mContext), 1, DISK_CACHE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

