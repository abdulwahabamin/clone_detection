    public static int getImageOrientation(String file) {

        Context context = getContext();
        Uri uri = getImageContentUri(context,new File(file));
        if(uri != null) {

            Cursor cursor = context.getContentResolver().query(uri,
                    new String[]{MediaStore.Images.ImageColumns.ORIENTATION},
                    null, null, null);

            try {
                if (cursor != null && cursor.moveToFirst()) {
                    Log.d("EXIF","Orientation found");
                    return cursor.getInt(0);
                } else {
                    return -1;
                }
            } catch (Exception e) {
                Log.d("EXIF","Orientation Exception");
                return 0;
            }
        }else{
            Log.d("EXIF","URI is null");
            return 0;
        }
    }

