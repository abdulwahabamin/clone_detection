    /**
     * @param mContext
     * @param id
     * @param name
     */
    public static void renamePlaylist(Context mContext, long id, String name) {

        if (name != null && name.length() > 0) {
            ContentResolver resolver = mContext.getContentResolver();
            ContentValues values = new ContentValues(1);
            values.put(PlaylistsColumns.NAME, name);
            resolver.update(Audio.Playlists.EXTERNAL_CONTENT_URI, values, BaseColumns._ID + "=?",
                    new String[] {
                        String.valueOf(id)
                    });
            Toast.makeText(mContext, "Playlist renamed", Toast.LENGTH_SHORT).show();
        }
    }

