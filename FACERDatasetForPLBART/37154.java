    public static String save2File(Context context, Bitmap bitmap) {
        String path = FileUtils.getCompressImagePath(context);
        FileOutputStream stream = null;
        Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
        int quality = 90;
        try {
            stream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (bitmap.compress(format, quality, stream)) {
            return path;
        }
        return null;
    }

