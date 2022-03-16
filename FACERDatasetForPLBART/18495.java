    /**
     * Queries MediaStore and returns a cursor with all unique playlists.
     */
    public static Cursor getAllUniquePlaylists(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String[] projection = { MediaStore.Audio.Playlists._ID,
                                MediaStore.Audio.Playlists.NAME };

        return contentResolver.query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                                     projection,
                                     null,
                                     null,
                                     MediaStore.Audio.Playlists.NAME + " ASC");

    }

