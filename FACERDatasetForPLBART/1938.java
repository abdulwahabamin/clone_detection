    public static int getImageOrientation(Uri contentPhotoUri){
        Context context = getContext().getApplicationContext();
        String[] orientationColumn = {MediaStore.Images.Media.ORIENTATION};
        Cursor cur = context.getContentResolver().query(contentPhotoUri, orientationColumn, null, null, null);
        int orientation = -1;
        if (cur != null && cur.moveToFirst()) {
            orientation = cur.getInt(cur.getColumnIndex(orientationColumn[0]));
        }else{
            Log.d("EXIF", "File: 0 results from query");
        }
        return orientation;
    }

