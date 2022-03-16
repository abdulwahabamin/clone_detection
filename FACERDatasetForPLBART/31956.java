    public int getMaxOrderId() {
        SQLiteDatabase db = getReadableDatabase();

        int maxOrderId = 0;
        Cursor cursor = null;
        try {
            cursor = db.query(
                LocationsContract.Locations.TABLE_NAME,
                new String[]{"MAX(order_id)"},
                null,
                null,
                null,
                null,
                null);

            cursor.moveToNext();
            maxOrderId = cursor.getInt(0);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return maxOrderId;
    }

