    protected ImageProvider( Activity activity ) {
    	mContext = activity;
    	memCache = ImageCache.getInstance( activity );
    	Resources resources = mContext.getResources();
    	DisplayMetrics metrics = resources.getDisplayMetrics();
    	thumbSize = (int) ( ( 153 * (metrics.densityDpi/160f) ) + 0.5f );
    }

