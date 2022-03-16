    private Cursor fetchGenres() {
        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI,
                new String[] {
                        MediaStore.Audio.Genres._ID,
                        MediaStore.Audio.Genres.NAME
                },
                MediaStore.Audio.Genres.NAME + " != ''",
                null,
                MediaStore.Audio.Genres.DEFAULT_SORT_ORDER);

        if (cursor == null) return null;
        cursor.setNotificationUri(getContext().getContentResolver(), MusicContract.Genre.CONTENT_URI);

        int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Genres._ID);
        int[] counts = new int[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext()) {
            long id = cursor.getLong(idColumn);
            counts[i++] = (id >= 0)
                    ? getCursorCount(fetchGenre(id))
                    : 0;
        }
        cursor.moveToPosition(-1);

        return new CursorWithCountColumn(cursor, counts);
    }

