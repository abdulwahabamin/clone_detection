    public static boolean playlistExists(Context context, String name) {
        Cursor cursor = MusicUtils.query(context, MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Audio.Playlists._ID},
                MediaStore.Audio.Playlists.NAME + "=?",
                new String[]{name},
                null);

        return cursor != null && cursor.moveToFirst();
    }

