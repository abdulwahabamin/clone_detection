    private static void getMusicContentByUri(Context context, Uri contentUri) {
        ContentResolver cr = context.getContentResolver();

        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
        Cursor cur = cr.query(contentUri, null, selection, null, sortOrder);
        int count;

        if (cur != null) {
            count = cur.getCount();

            if (count > 0) {
                while (cur.moveToNext()) {
                    String data = cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.DATA));
                    createSongEntry(context, data);
                }
            }
            cur.close();
        }
    }

