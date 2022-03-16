    /**
     * Check if the file is a valid image document allowed by android to be printed
     *
     * @param file The image to check
     * @return boolean If the image is a valid document
     */
    private static boolean isValidImageDocument(String file) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeFile(file, options);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return bitmap != null;
    }

