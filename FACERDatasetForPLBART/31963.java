    public void updateAutoLocationAddress(final Context context, final String locale, final Address address) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS, getAddressAsBytes(address));
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCALE, locale);
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND, 1);
        values.put(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS, System.currentTimeMillis());
        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,values,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID +"=0",
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
        SensorLocationUpdater.autolocationForSensorEventAddressFound = true;
        appendLog(context,
                  TAG,
                 "updateAutoLocationAddress:autolocationForSensorEventAddressFound=",
                        SensorLocationUpdater.autolocationForSensorEventAddressFound);
    }

