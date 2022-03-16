    public void setNoLocationFound() {
        appendLog(context, TAG, "setNoLocationFound:entered");
        appendLog(context, TAG, "setNoLocationFound:run");
        SQLiteDatabase db = getWritableDatabase();
        appendLog(context, TAG, "setNoLocationFound:writableDB");
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND, 0);
        values.put(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS, System.currentTimeMillis());

        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,values,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID +"=0",
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
        appendLog(context, TAG, "setNoLocationFound:updated");
        SensorLocationUpdater.autolocationForSensorEventAddressFound = false;
        appendLog(context,
                TAG,
                "setNoLocationFound:autolocationForSensorEventAddressFound=",
                        SensorLocationUpdater.autolocationForSensorEventAddressFound);
    }

