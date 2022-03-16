    public void updateAutoLocationGeoLocation(final double latitude,
                                              final double longitude,
                                              final String locationSource,
                                              final float accuracy,
                                              final long locationTime) {
        appendLog(context, TAG, "updateLocationSource:entered:", latitude, ":", longitude, ":", locationSource);
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_LONGITUDE, longitude);
        values.put(LocationsContract.Locations.COLUMN_NAME_LATITUDE, latitude);
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE, locationSource);
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_ACCURACY, accuracy);
        values.put(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS, locationTime);
        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,values,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID +"=0",
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
    }

