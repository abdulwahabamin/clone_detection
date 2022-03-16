    @Override
    protected Bitmap doInBackground(String... ignored) {
        Context context = mContextReference.get();
        if (context == null) {
            return null;
        }
        //Get bitmap from proper source
        File nFile = null;
        
        if( mImageInfo.source.equals(SRC_FILE)  && !isCancelled()){
        	nFile = ImageUtils.getImageFromMediaStore( context, mImageInfo );
        }
        else if ( mImageInfo.source.equals(SRC_LASTFM)  && !isCancelled()){
        	nFile = ImageUtils.getImageFromWeb( context, mImageInfo );
        }
        else if ( mImageInfo.source.equals(SRC_GALLERY)  && !isCancelled()){
        	nFile = ImageUtils.getImageFromGallery( context, mImageInfo );
        }        	
        else if ( mImageInfo.source.equals(SRC_FIRST_AVAILABLE)  && !isCancelled()){
        	Bitmap bitmap = null;
        	if( mImageInfo.size.equals( SIZE_NORMAL ) ){
        		bitmap = ImageUtils.getNormalImageFromDisk( context, mImageInfo );
        	}
        	else if( mImageInfo.size.equals( SIZE_THUMB ) ){
        		bitmap = ImageUtils.getThumbImageFromDisk( context, mImageInfo, mThumbSize );
        	}
        	//if we have a bitmap here then its already properly sized
        	if( bitmap != null ){
        		return bitmap;
        	}
        	
        	if( mImageInfo.type.equals( TYPE_ALBUM ) ){
        		nFile = ImageUtils.getImageFromMediaStore( context, mImageInfo );
        	}
        	if( nFile == null && ( mImageInfo.type.equals( TYPE_ALBUM ) || mImageInfo.type.equals( TYPE_ARTIST ) ) )
        		nFile = ImageUtils.getImageFromWeb( context, mImageInfo );
        }
        if( nFile != null ){        	
        	// if requested size is normal return it
        	if( mImageInfo.size.equals( SIZE_NORMAL ) )
        		return BitmapFactory.decodeFile(nFile.getAbsolutePath());
        	//if it makes it here we want a thumbnail image
        	return ImageUtils.getThumbImageFromDisk( context, nFile, mThumbSize );
        }
        return null;
    }

