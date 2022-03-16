    private ListRow readCursor(long id, String name, Cursor cursor, String nameColumn, String countColumn) {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter();

        if (cursor != null) {
            int idColumnIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
            int nameColumnIndex = cursor.getColumnIndexOrThrow(nameColumn);
            int countColumnIndex = cursor.getColumnIndexOrThrow(countColumn);
            while (cursor.moveToNext()) {
                listRowAdapter.add(new CategoryItem(
                        cursor.getLong(idColumnIndex),
                        cursor.getString(nameColumnIndex),
                        cursor.getInt(countColumnIndex)));
            }
            cursor.close();
        }

        return new ListRow(new HeaderItem(id, name), listRowAdapter);
    }

