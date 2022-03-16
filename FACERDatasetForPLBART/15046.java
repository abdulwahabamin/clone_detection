    public GetBitmapTask( int thumbSize, ImageInfo imageInfo, OnBitmapReadyListener listener, Context context ) {
        mListenerReference = new WeakReference<OnBitmapReadyListener>(listener);
        mContextReference = new WeakReference<Context>(context);
        mImageInfo = imageInfo;
    	mThumbSize = thumbSize;
    }

