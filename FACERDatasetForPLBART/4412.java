    public static Bitmap getThumbnail(Context context, String path) {
        //ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(path), MediaStore.Images.Thumbnails.MINI_KIND);
        synchronized (bmf) {
            ContentResolver cr = context.getContentResolver();
            Cursor ca = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.MediaColumns._ID}, MediaStore.MediaColumns.DATA + "=?", new String[]{path}, null);
            if (ca != null && ca.moveToFirst()) {
                int id = ca.getInt(ca.getColumnIndex(MediaStore.MediaColumns._ID));
                ca.close();
                return MediaStore.Images.Thumbnails.getThumbnail(cr, id, MediaStore.Images.Thumbnails.MINI_KIND, null);
            }
            if (ca != null)
                ca.close();
        }
        return null;

    }

