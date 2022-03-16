    @Override
    public void bitmapReady(Bitmap bitmap, String tag) {
        if (bitmap == null) {
            unavailable.add(tag);
        }
        else
        {
            memCache.add(tag, bitmap);
        }
        Set<ImageView> pendingImages = pendingImagesMap.get(tag);
        if (pendingImages != null) {
            pendingImagesMap.remove(tag);
            for (ImageView imageView : pendingImages) {
                setLoadedBitmap(imageView, bitmap, tag);
            }
        }
    }

