    public void updateEnabled(long locationId, boolean enabled) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_ENABLED, enabled);

        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME, values,
                LocationsContract.Locations._ID + "=" + locationId,
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
    }

