    /**
     * Used to resize app icon, such that all appIcons have same size
     *
     * @param image
     * @param scaleFactor
     * @return
     */
    public Drawable scaleImage(Drawable image, float scaleFactor) {

        if ((image == null) || !(image instanceof BitmapDrawable)) {
            return image;
        }

        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        return new BitmapDrawable(context.getResources(), getResizedBitmap(bitmap, (int) scaleFactor));

    }

