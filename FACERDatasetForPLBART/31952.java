    private void createLocation(Location location) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS,
                   LocationsDbHelper.getAddressAsBytes(location.getAddress()));
        values.put(LocationsContract.Locations.COLUMN_NAME_LONGITUDE, location.getLongitude());
        values.put(LocationsContract.Locations.COLUMN_NAME_LATITUDE, location.getLatitude());
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCALE, location.getLocaleAbbrev());
        values.put(LocationsContract.Locations.COLUMN_NAME_ORDER_ID, location.getOrderId());
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE, location.getLocationSource());
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND, location.isAddressFound());
        values.put(LocationsContract.Locations.COLUMN_NAME_ENABLED, location.isEnabled());
        values.put(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS, location.getLastLocationUpdate());
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_ACCURACY, location.getAccuracy());
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_NICKNAME, location.getNickname());
        values.put(LocationsContract.Locations._ID, location.getId());

        long newLocationRowId = db.insert(LocationsContract.Locations.TABLE_NAME, null, values);
        appendLog(context, TAG, "Location in memory created: ", newLocationRowId, ":", location.getId());
    }

