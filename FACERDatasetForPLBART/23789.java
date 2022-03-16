    public void loadImage(long id, ImageView imageview) {
        imageview.setImageDrawable(mAppIcon);

        Bitmap image = cache.get(id);
        if (image != null) {
            imageview.setImageBitmap(image);
        } else if (badArtwork.get(id) == null) {
            startBackgroundImageExtraction(imageview, id);
        } else
            Log.d(TAG, "display(" + id + ") marked as bad.");
    }

