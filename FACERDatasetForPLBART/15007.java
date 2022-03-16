    private boolean setCachedBitmap(ImageView imageView, String tag) {
        if (unavailable.contains(tag)) {
            handleBitmapUnavailable(imageView, tag);
            return true;
        }
        Bitmap bitmap = memCache.get(tag);
        if (bitmap == null)
            return false;
        imageView.setTag(tag);
        imageView.setImageBitmap(bitmap);
        return true;
    }

