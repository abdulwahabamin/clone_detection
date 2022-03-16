    public void setImageDrawable(final File f, final int width, int height) {
    	//final int THUMBSIZE = 200;
    	usefile=f;
        usewidth=width;
        useheight=height;
    	mDrawable=null;
        ImageCache.CacheBitmap cb=ImageCache.get(f.getPath());
        if(cb==null) {

            cb = ImageCache.getNewCacheBitmap();
            cb.status = ImageCache.CACHE_B_LOADING;
            ImageCache.put(f.getPath(), cb);
            loadImage = new LoadImageTask();
            loadImage.setData(f, width, height);
            loadImage.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
        } else if(cb.status==ImageCache.CACHE_B_LOADING) {
            //mImage.setImageBitmap(cb.bitmap);
            mImage.setVisibility(View.VISIBLE);
            //mImage.setCa(null);
            //mImage.setAnimation(alphaAnim);
            mSpinner.setVisibility(View.GONE);
        } else if(cb.status==ImageCache.CACHE_B_LOADED) {
            mBitmap=cb.bitmap;
            mImage.setImageBitmap(cb.bitmap);
            mImage.setVisibility(View.VISIBLE);
            //mImage.setCa(null);
            //mImage.setAnimation(alphaAnim);
            mSpinner.setVisibility(View.GONE);
//this.invalidate();
        }

    }

