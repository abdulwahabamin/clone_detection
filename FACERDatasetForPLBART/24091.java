    public static void renamePlaylist(Context context, long playlistId, String name) {
        if (name != null && name.length() > 0) {
            if (playlistExists(context, name)) {
                Toast.makeText(context, R.string.playlist_already_exists, Toast.LENGTH_SHORT).show();
            } else {
                ContentValues values = new ContentValues(1);
                values.put(MediaStore.Audio.Playlists.NAME, name);
                context.getContentResolver().update(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                        values,
                        MediaStore.Audio.Playlists._ID + "=?",
                        new String[]{Long.valueOf(playlistId).toString()});

                Toast.makeText(context, R.string.playlist_renamed_message, Toast.LENGTH_SHORT).show();
            }
        }
    }

