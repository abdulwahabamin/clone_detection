    /**
     * @param mContext
     * @param genre_id
     * @param default_name
     * @return genre name
     */
    public static String getGenreName(Context mContext, long genre_id, boolean default_name) {
        String where = BaseColumns._ID + "=" + genre_id;
        String[] cols = new String[] {
            GenresColumns.NAME
        };
        Uri uri = Audio.Genres.EXTERNAL_CONTENT_URI;
        Cursor cursor = mContext.getContentResolver().query(uri, cols, where, null, null);
        if (cursor == null){
            return MediaStore.UNKNOWN_STRING;
        }
        if (cursor.getCount() <= 0) {
            if (default_name)
                return mContext.getString(R.string.unknown);
            else
                return MediaStore.UNKNOWN_STRING;
        } else {
            cursor.moveToFirst();
            String name = cursor.getString(0);
            cursor.close();
            if (name == null || MediaStore.UNKNOWN_STRING.equals(name)) {
                if (default_name)
                    return mContext.getString(R.string.unknown);
                else
                    return MediaStore.UNKNOWN_STRING;
            }
            return name;
        }
    }

