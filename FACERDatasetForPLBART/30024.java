    public void addCity(String string) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CITY, string);

        // Inserting Row
        db.insert(TABLE_CITIES, null, values);
        //2nd argument is String containing nullColumnHack

        db.close(); // Closing database connection  
    }

