    public void deleteRecordFromTable(Location location) {
        int deletedOrderId = location.getOrderId();
        SQLiteDatabase db = getWritableDatabase();
        String selection = LocationsContract.Locations._ID + " = ?";
        String[] selectionArgs = {location.getId().toString()};
        db.delete(LocationsContract.Locations.TABLE_NAME, selection, selectionArgs);

        String[] projection = {
                LocationsContract.Locations._ID,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID
        };

        String sortOrder = LocationsContract.Locations.COLUMN_NAME_ORDER_ID;

        Cursor cursor = null;
        try {
            cursor = db.query(
                LocationsContract.Locations.TABLE_NAME,
                projection,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID + ">" + deletedOrderId,
                null,
                null,
                null,
                sortOrder
            );

            while (cursor.moveToNext()) {
                long itemId = cursor.getInt(cursor.getColumnIndexOrThrow(LocationsContract.Locations._ID));
                int orderId = cursor.getInt(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_ORDER_ID));
                ContentValues values = new ContentValues();
                values.put(LocationsContract.Locations.COLUMN_NAME_ORDER_ID, orderId - 1);
                db.updateWithOnConflict(
                        LocationsContract.Locations.TABLE_NAME,
                        values,
                        LocationsContract.Locations._ID +"=" + itemId,
                        null,
                        SQLiteDatabase.CONFLICT_IGNORE);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

