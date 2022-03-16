    public void updateNickname(int locationOrderId, String locationNickname) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_NICKNAME, locationNickname);
        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,
                values,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID +"=" + locationOrderId,
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
    }

