    public boolean cityExists(String string) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + KEY_CITY + " FROM " + TABLE_CITIES + ";", null);

        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.moveToFirst()) {
                do {
                    if (cursor.getString(0).equals(string))
                        return true;
                }
                while (cursor.moveToNext());
            }
        }
        cursor.close();
        return false;
    }

