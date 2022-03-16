    /**
     * @param context
     * @param id
     * @return
     */
    public static long[] getSongListForPlaylist(Context context, long id) {
        final String[] projection = new String[] {
            Audio.Playlists.Members.AUDIO_ID
        };
        String sortOrder = Playlists.Members.DEFAULT_SORT_ORDER;
        Uri uri = Playlists.Members.getContentUri(EXTERNAL, id);
        Cursor cursor = query(context, uri, projection, null, null, sortOrder);
        if (cursor != null) {
            long[] list = getSongListForCursor(cursor);
            cursor.close();
            return list;
        }
        return sEmptyList;
    }

