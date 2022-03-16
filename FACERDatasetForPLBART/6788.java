    /**
     * Used for loading and decoding thumbnails from files.
     * 
     * @author PhilipHayes
     * @param context Current application context.
     */
	public ThumbnailLoader(Context context) {
		mContext = context;
		
		purger = new Runnable(){
			@Override
			public void run() {
				Log.d(TAG, "Purge Timer hit; Clearing Caches.");
				clearCaches();
			}
		};
		
		purgeHandler = new Handler();
		mExecutor = Executors.newFixedThreadPool(POOL_SIZE);
		
		mBlacklist = new ArrayList<String>();
		mSoftBitmapCache = new ConcurrentHashMap<String, SoftReference<Bitmap>>(MAX_CACHE_CAPACITY / 2);
		mHardBitmapCache = new LinkedHashMap<String, Bitmap>(MAX_CACHE_CAPACITY / 2, 0.75f, true){
			
			/***/
			private static final long serialVersionUID = 1347795807259717646L;
			
			@Override
			protected boolean removeEldestEntry(LinkedHashMap.Entry<String, Bitmap> eldest){
				// Moves the last used item in the hard cache to the soft cache.
				if(size() > MAX_CACHE_CAPACITY){
					mSoftBitmapCache.put(eldest.getKey(), new SoftReference<Bitmap>(eldest.getValue()));
					return true;
				} else {
					return false;
				}
			}
		};
	}  

