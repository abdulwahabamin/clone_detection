    /**
     * @param context
     * @param id
     * @return
     */
    public static long[] getSongListForArtist(Context context, long id) {
        final String[] projection = new String[] {
            BaseColumns._ID
        };
        String selection = AudioColumns.ARTIST_ID + "=" + id + " AND " + AudioColumns.IS_MUSIC
                + "=1";
        String sortOrder = AudioColumns.ALBUM_KEY + "," + AudioColumns.TRACK;
        Uri uri = Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = query(context, uri, projection, selection, null, sortOrder);
        if (cursor != null) {
            long[] list = getSongListForCursor(cursor);
            cursor.close();
            return list;
        }
        return sEmptyList;
    }

