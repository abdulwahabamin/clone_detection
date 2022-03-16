    public final static ImageProvider getInstance( final Activity activity ) {    	
        if (mInstance == null) {
            mInstance = new ImageProvider( activity );
            mInstance.setImageCache(ImageCache.findOrCreateCache(activity));
        }
        return mInstance;        
    }

