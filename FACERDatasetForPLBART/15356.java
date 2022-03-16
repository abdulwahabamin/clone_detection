    @Override
    public void bitmapReady(Bitmap bitmap, String tag) {
        synchronized (this) {
            if (tag.equals(mAlbumBitmapTag)) {
                mAlbumBitmap = bitmap;
            }
        }
        notifyChange(META_CHANGED);
        if (status != null)
        	updateNotification();

        mAlbumBitmapTask = null;
    }

