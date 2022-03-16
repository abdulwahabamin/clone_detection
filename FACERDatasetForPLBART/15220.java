    /**
     * @param playlist_id
     * @return playlist name
     */
    public static String getPlaylistName(Context mContext, long playlist_id) {
        String where = BaseColumns._ID + "=" + playlist_id;
        String[] cols = new String[] {
            PlaylistsColumns.NAME
        };
        Uri uri = Audio.Playlists.EXTERNAL_CONTENT_URI;
        Cursor cursor = mContext.getContentResolver().query(uri, cols, where, null, null);
        if (cursor == null){
            return "";
        }
        if (cursor.getCount() <= 0)
            return "";
        cursor.moveToFirst();
        String name = cursor.getString(0);
        cursor.close();
        return name;
    }

