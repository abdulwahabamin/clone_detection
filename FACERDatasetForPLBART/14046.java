    public void loadImage( ImageView imageView, ImageInfo imageInfo ){
    	String tag = ImageUtils.createShortTag(imageInfo) + imageInfo.size;
    	if( imageInfo.source.equals(SRC_FILE) || imageInfo.source.equals(SRC_LASTFM) || imageInfo.source.equals(SRC_GALLERY)){
    		clearFromMemoryCache( ImageUtils.createShortTag(imageInfo) );
    		asyncLoad( tag, imageView, new GetBitmapTask( thumbSize, imageInfo, this, imageView.getContext() ) );
		}
    	if(!setCachedBitmap(imageView, tag)){
            asyncLoad( tag, imageView, new GetBitmapTask( thumbSize, imageInfo, this, imageView.getContext() ) );
        }
    }

