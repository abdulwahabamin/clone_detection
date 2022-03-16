    void initialize(SQLiteDatabase db) {
        db.delete(TABLE_NAME, null, null);

        Cursor cursor = getMediaStoreCursor();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                ContentValues values = putValues(cursor);

                insertValues(values, db);
            } while (cursor.moveToNext());

            cursor.close();
        }
    }

