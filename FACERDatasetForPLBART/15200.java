    /**
     * @param context
     * @param id
     * @return
     */
    public static boolean isFavorite(Context context, long id) {

        long favorites_id;

        if (id < 0) {

        } else {
            ContentResolver resolver = context.getContentResolver();

            String favorites_where = PlaylistsColumns.NAME + "='" + PLAYLIST_NAME_FAVORITES + "'";
            String[] favorites_cols = new String[] {
                BaseColumns._ID
            };
            Uri favorites_uri = Audio.Playlists.EXTERNAL_CONTENT_URI;
            Cursor cursor = resolver.query(favorites_uri, favorites_cols, favorites_where, null,
                    null);
            if (cursor.getCount() <= 0) {
                favorites_id = createPlaylist(context, PLAYLIST_NAME_FAVORITES);
            } else {
                cursor.moveToFirst();
                favorites_id = cursor.getLong(0);
                cursor.close();
            }

            String[] cols = new String[] {
                Playlists.Members.AUDIO_ID
            };
            Uri uri = Playlists.Members.getContentUri(EXTERNAL, favorites_id);
            Cursor cur = resolver.query(uri, cols, null, null, null);

            cur.moveToFirst();
            while (!cur.isAfterLast()) {
                if (cur.getLong(0) == id) {
                    cur.close();
                    return true;
                }
                cur.moveToNext();
            }
            cur.close();
            return false;
        }
        return false;
    }

