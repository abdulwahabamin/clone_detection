    public Bitmap getAlbumArt(final Uri uri){
        Bitmap bm = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            ParcelFileDescriptor pfd = mContext.getContentResolver().openFileDescriptor(uri, "r");
            if (pfd != null) {
                FileDescriptor fd = pfd.getFileDescriptor();
                bm = BitmapFactory.decodeFileDescriptor(fd, null, options);
                pfd = null;
                fd = null;
            }
        }
        catch (Exception e){}
        return bm;
    }

