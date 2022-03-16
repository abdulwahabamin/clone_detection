    public List<String> getCities() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CITIES + " ORDER BY " + KEY_ID + " DESC;", null);
        List<String> categoryList = new ArrayList<>();

        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.moveToFirst()) {
                do {
                    categoryList.add(cursor.getString(0));
                }
                while (cursor.moveToNext());
            }
            cursor.close();
        }
        return categoryList;
    }

