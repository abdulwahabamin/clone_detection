    public static Bitmap getBitmap(Context context, File image) {

        Bitmap bm = getThumbnail(context, image.getPath());
        if(bm==null)
            bm = BitmapFactory.decodeFile(image.getPath(), null);


        return bm;

    }

