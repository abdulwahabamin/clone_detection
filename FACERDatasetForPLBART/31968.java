    public void updateLastUpdatedAndLocationSource(final long locationId,
                                                   final long updateTime,
                                                   final String locationSource) {
        appendLog(context, TAG, "updateLocationSource:entered:", locationId, ":", locationSource);
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE, locationSource);
        values.put(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS, updateTime);

        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,
                values,
                LocationsContract.Locations._ID + "=" + locationId,
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
        appendLog(context, TAG, "updateLocationSource:updated");
    }

