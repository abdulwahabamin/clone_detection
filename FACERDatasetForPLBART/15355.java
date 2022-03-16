    private synchronized void updateAlbumBitmap() {
    	if (mAlbumBitmapTask != null) {
    		mAlbumBitmapTask.cancel(true);
    		mAlbumBitmapTask = null;
    	}
    	
    	if (mCursor == null) {
    		return;
    	}

        ImageInfo mInfo = new ImageInfo();
        mInfo.type = TYPE_ALBUM;
        mInfo.size = SIZE_THUMB;
        mInfo.source = SRC_FIRST_AVAILABLE;
        mInfo.data = new String[]{ String.valueOf(getAlbumId()), getArtistName(), getAlbumName() };

        String tag = ImageUtils.createShortTag( mInfo ) + SIZE_THUMB ;
        if (tag == mAlbumBitmapTag)
            return;

        mAlbumBitmapTag = tag;
        mAlbumBitmap = null;
        

    	Resources resources = getResources();
    	DisplayMetrics metrics = resources.getDisplayMetrics();
    	int thumbSize = (int) ( ( 153 * (metrics.densityDpi/160f) ) + 0.5f );

        mAlbumBitmapTask = new GetBitmapTask( thumbSize, mInfo,  this,  this );
        mAlbumBitmapTask.execute();
    }

