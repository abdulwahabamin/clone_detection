    private ListRow readFolderCursor(long id, String name, Cursor cursor, String nameColumn, String countColumn, String pathColumn) {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter();

        if (cursor != null) {
            int idColumnIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
            int nameColumnIndex = cursor.getColumnIndexOrThrow(nameColumn);
            int countColumnIndex = cursor.getColumnIndexOrThrow(countColumn);
            int pathColumnIndex = cursor.getColumnIndexOrThrow(pathColumn);
            while (cursor.moveToNext()) {
                listRowAdapter.add(new FolderItem(
                        cursor.getLong(idColumnIndex),
                        cursor.getString(nameColumnIndex),
                        cursor.getInt(countColumnIndex),
                        cursor.getString(pathColumnIndex)));
            }
            cursor.close();
        }

        return new ListRow(new HeaderItem(id, name), listRowAdapter);
    }

