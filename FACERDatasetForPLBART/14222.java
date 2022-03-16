    /**
     * @param context
     * @param id
     * @return
     */
    public static long[] getSongListForGenre(Context context, long id) {
        String[] projection = new String[] {
            BaseColumns._ID
        };
        StringBuilder selection = new StringBuilder();
        selection.append(AudioColumns.IS_MUSIC + "=1");
        selection.append(" AND " + MediaColumns.TITLE + "!=''");
        Uri uri = Genres.Members.getContentUri(EXTERNAL, id);
        Cursor cursor = context.getContentResolver().query(uri, projection, selection.toString(),
                null, null);
        if (cursor != null) {
            long[] list = getSongListForCursor(cursor);
            cursor.close();
            return list;
        }
        return sEmptyList;
    }

