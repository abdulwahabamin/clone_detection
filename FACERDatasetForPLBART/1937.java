    public static int getImageOrientation(Context context, Uri contentPhotoUri) {
        Cursor cursor = context.getContentResolver().query(contentPhotoUri,
                new String[]{MediaStore.Images.ImageColumns.ORIENTATION},
                null, null, null);
        try {
            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            } else {
                return -1;
            }
        }catch(Exception e){
            return 0;
        }
    }

