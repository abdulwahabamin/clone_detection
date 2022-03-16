    /**
     * @param context
     * @param id
     * @return
     */
    public static long[] getSongListForAlbum(Context context, long id) {
        final String[] projection = new String[] {
            BaseColumns._ID
        };
        String selection = AudioColumns.ALBUM_ID + "=" + id + " AND " + AudioColumns.IS_MUSIC
                + "=1";
        String sortOrder = AudioColumns.TRACK;
        Uri uri = Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = query(context, uri, projection, selection, null, sortOrder);
        if (cursor != null) {
            long[] list = getSongListForCursor(cursor);
            cursor.close();
            return list;
        }
        return sEmptyList;
    }

