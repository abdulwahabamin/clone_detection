    /**
     * @param context
     * @return
     */
    public static long getFavoritesId(Context context) {
        long favorites_id = -1;
        String favorites_where = PlaylistsColumns.NAME + "='" + "Favorites" + "'";
        String[] favorites_cols = new String[] {
            BaseColumns._ID
        };
        Uri favorites_uri = Audio.Playlists.EXTERNAL_CONTENT_URI;
        Cursor cursor = query(context, favorites_uri, favorites_cols, favorites_where, null, null);
        if (cursor.getCount() <= 0) {
            favorites_id = createPlaylist(context, "Favorites");
        } else {
            cursor.moveToFirst();
            favorites_id = cursor.getLong(0);
            cursor.close();
        }
        return favorites_id;
    }

