    public void setImageDrawable(final File f) {
    	final int THUMBSIZE = 200;
    	
    	mDrawable=null;
    	mBitmap = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(f.getAbsolutePath()),
                THUMBSIZE, THUMBSIZE);
        //mDrawable = image;
        mSpinner.setVisibility(View.GONE);
        mImage.setVisibility(View.VISIBLE);
        imageLoadedHandler.sendEmptyMessage(COMPLETE);

    }

