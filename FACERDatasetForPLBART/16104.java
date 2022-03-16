    public ContentValues putValues(Cursor cursor) {
        ContentValues values = new ContentValues();
        values.put(Columns._ID, Library.getLong(cursor, MediaStore.Audio.Media._ID));
        values.put(Columns.SONG_ID, Library.getLong(cursor, MediaStore.Audio.Media._ID));
        values.put(Columns.ALBUM_ID, Library.getLong(cursor, MediaStore.Audio.Media.ALBUM_ID));
        values.put(Columns.ARTIST_ID, Library.getLong(cursor, MediaStore.Audio.Media.ARTIST_ID));
        values.put(Columns.BOOKMARK, Library.getLong(cursor, MediaStore.Audio.Media.BOOKMARK));
        values.put(Columns.DATE_ADDED, Library.getLong(cursor, MediaStore.Audio.Media.DATE_ADDED));
        values.put(Columns.DATE_MODIFIED, Library.getLong(cursor, MediaStore.Audio.Media.DATE_MODIFIED));
        values.put(Columns.DURATION, Library.getLong(cursor, MediaStore.Audio.Media.DURATION));
        values.put(Columns.FILE_PATH, Library.getString(cursor, MediaStore.Audio.Media.DATA));
        values.put(Columns.SIZE, Library.getLong(cursor, MediaStore.Audio.Media.SIZE));
        values.put(Columns.TITLE, Library.getString(cursor, MediaStore.Audio.Media.TITLE));
        values.put(Columns.TRACK, Library.getInt(cursor, MediaStore.Audio.Media.TRACK));
        values.put(Columns.YEAR, Library.getInt(cursor, MediaStore.Audio.Media.YEAR));
        values.put(Columns.IS_REMOTE, 0);

        return values;
    }

