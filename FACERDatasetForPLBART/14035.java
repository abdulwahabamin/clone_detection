    public void add(final String data, final Bitmap bitmap) {
        if (data == null || bitmap == null) {
            return;
        }
        if (get(data) == null) {
            mLruCache.put(data, bitmap);
        }
    }

