    public final Bitmap get(final String data) {
        if (data == null) {
            return null;
        }
        if (mLruCache != null) {
            final Bitmap mBitmap = mLruCache.get(data);
            if (mBitmap != null) {
                return mBitmap;
            }
        }
        return null;
    }

