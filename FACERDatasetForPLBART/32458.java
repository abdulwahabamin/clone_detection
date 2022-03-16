    private ContentValues prepareValues(Location location, Location locationInFile) {
        ContentValues values = new ContentValues();
        if ((location.getAddress() != null) && !location.getAddress().equals(locationInFile.getAddress())) {
            values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS, LocationsDbHelper.getAddressAsBytes(location.getAddress()));
        }
        if (location.getLongitude() != locationInFile.getLongitude()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LONGITUDE, location.getLongitude());
        }
        if (location.getLatitude() != locationInFile.getLatitude()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LATITUDE, location.getLatitude());
        }
        if ((location.getLocale() != null) && !location.getLocale().equals(locationInFile.getLocale())) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LOCALE, location.getLocaleAbbrev());
        }
        if (location.getOrderId() != locationInFile.getOrderId()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_ORDER_ID, location.getOrderId());
        }
        if ((location.getLocationSource() != null) && !location.getLocationSource().equals(locationInFile.getLocationSource())) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE, location.getLocationSource());
        }
        if (location.isAddressFound() != locationInFile.isAddressFound()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND, location.isAddressFound());
        }
        if (location.isEnabled() != locationInFile.isEnabled()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_ENABLED, location.isEnabled());
        }
        if (location.getLastLocationUpdate() != locationInFile.getLastLocationUpdate()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS, location.getLastLocationUpdate());
        }
        if (location.getAccuracy() != locationInFile.getAccuracy()) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_ACCURACY, location.getAccuracy());
        }
        if ((location.getNickname() != null) && !location.getNickname().equals(locationInFile.getNickname())) {
            values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_NICKNAME, location.getNickname());
        }
        return values;
    }

