    @Override
    public ContentValues putValues(Cursor cursor) {
        ContentValues values = new ContentValues();

        values.put(Columns._ID, Library.getLong(cursor, MediaStore.Audio.Artists._ID));
        values.put(Columns.ARTIST_ID, Library.getLong(cursor, MediaStore.Audio.Artists._ID));
        values.put(Columns.ARTIST_NAME, Library.getString(cursor, MediaStore.Audio.Artists.ARTIST));
        values.put(Columns.NUMBER_OF_ALBUMS, Library.getInt(cursor, MediaStore.Audio.Artists.NUMBER_OF_ALBUMS));
        values.put(Columns.NUMBER_OF_TRACKS, Library.getInt(cursor, MediaStore.Audio.Artists.NUMBER_OF_TRACKS));
        values.put(Columns.IS_REMOTE, 0);

        return values;
    }

