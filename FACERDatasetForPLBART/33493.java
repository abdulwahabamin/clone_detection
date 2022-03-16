    private void updateLastQueryTime(Cursor cursor, long lastQueryTime) {
        ContentValues newValues = new ContentValues();
        newValues.put(CityTable.COLUMN_ORDERING_VALUE, lastQueryTime);
        Uri rowUri = getRowUri(cursor);
        int columnIndexForRowId = cursor.getColumnIndexOrThrow(CityTable._ID);
        int rowId = cursor.getInt(columnIndexForRowId);
        context.getContentResolver().update(rowUri, newValues, CityTable._ID + "=?",
                new String[]{Integer.toString(rowId)});
    }

