    private void storeLocation() {
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this.getApplicationContext());

        int currentMaxOrderId = locationsDbHelper.getMaxOrderId();
        SQLiteDatabase db = locationsDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS, locationsDbHelper.getAddressAsBytes(address));
        values.put(LocationsContract.Locations.COLUMN_NAME_LONGITUDE, longitude);
        values.put(LocationsContract.Locations.COLUMN_NAME_LATITUDE, latitude);
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCALE, locale);
        values.put(LocationsContract.Locations.COLUMN_NAME_ORDER_ID, currentMaxOrderId + 1);
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE, "");
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND, 1);

        long newLocationRowId = db.insert(LocationsContract.Locations.TABLE_NAME, null, values);

        SensorLocationUpdater.autolocationForSensorEventAddressFound = true;
        appendLog(this,
                TAG,
                "autolocationForSensorEventAddressFound=",
                        SensorLocationUpdater.autolocationForSensorEventAddressFound);

        if (currentMaxOrderId == 0) {
            Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.RESTART_ALARM_SERVICE");
            intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
            startService(intentToStartUpdate);
        }
        sendMessageToReconciliationDbService(true);
    }

