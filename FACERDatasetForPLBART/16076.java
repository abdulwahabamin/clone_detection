    @Override
    public ContentValues putValues(Cursor cursor) {
        ContentValues values = new ContentValues();

        values.put(Columns._ID, Library.getLong(cursor, MediaStore.Audio.Albums._ID));
        values.put(Columns.ALBUM_ID, Library.getLong(cursor, MediaStore.Audio.Albums._ID));
        values.put(Columns.ALBUM_NAME, Library.getString(cursor, MediaStore.Audio.Albums.ALBUM));
        values.put(Columns.ALBUM_ART, Library.getString(cursor, MediaStore.Audio.Albums.ALBUM_ART));
        values.put(Columns.ARTIST, Library.getString(cursor, MediaStore.Audio.Albums.ARTIST));
        values.put(Columns.NUMBER_OF_SONGS, Library.getInt(cursor, MediaStore.Audio.Albums.NUMBER_OF_SONGS));
        values.put(Columns.IS_REMOTE, 0);

        return values;
    }

