    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_LOCATIONS);
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_ORDER_ID, 0);
        values.put(LocationsContract.Locations.COLUMN_NAME_ENABLED, true);
        db.insert(LocationsContract.Locations.TABLE_NAME, null, values);
    }

