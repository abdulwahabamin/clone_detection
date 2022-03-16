    public static String getFilePathFromUri(Context context, Uri photoUri) {
        Cursor cursor = context.getContentResolver().query(photoUri,
                new String[]{MediaStore.Images.ImageColumns.DATA}, null,
                null, null);

        try {
            if (cursor.moveToFirst()) {
                int column_index = cursor
                        .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                return cursor.getString(column_index);
            } else {
                return "";
            }
        }catch (Exception e){
            return photoUri.getPath();
        }
    }

