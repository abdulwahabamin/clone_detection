    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        OnBitmapReadyListener listener = mListenerReference.get();
        if(bitmap == null && !isCancelled()){
        	if(mImageInfo.size.equals(SIZE_THUMB))
        		bitmap = BitmapFactory.decodeResource(mContextReference.get().getResources(),
        													R.drawable.no_art_small);
        	else if(mImageInfo.size.equals(SIZE_NORMAL))
        		bitmap = BitmapFactory.decodeResource(mContextReference.get().getResources(),
        													R.drawable.no_art_normal);
        }
        if (bitmap != null && !isCancelled()) {
            if (listener != null) {
                	listener.bitmapReady(bitmap,  ImageUtils.createShortTag(mImageInfo) + mImageInfo.size );
            }
        }
    }

