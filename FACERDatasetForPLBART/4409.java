    public static Bitmap getPreview(File image, int toSize) {
        //File image = new File(uri);

        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(image.getPath(), bounds);
        if ((bounds.outWidth == -1) || (bounds.outHeight == -1))
            return null;

        int originalSize = (bounds.outHeight > bounds.outWidth) ? bounds.outHeight
                : bounds.outWidth;

        BitmapFactory.Options opts = new BitmapFactory.Options();
        if(originalSize>300) {
            opts.inSampleSize = originalSize / toSize;
        }
        Bitmap bm = BitmapFactory.decodeFile(image.getPath(), opts);


        return bm;

    }

