    private int fetchFolderCount(String path) {
        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Audio.AudioColumns._ID},
                MediaStore.Audio.AudioColumns.IS_MUSIC + "=1 AND " + MediaStore.Audio.AudioColumns.DATA + " LIKE ?",
                new String[]{path + "%"}, null);

        int count = 0;
        if (cursor != null) {
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

