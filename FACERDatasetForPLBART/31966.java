    public void updateLocationSource(final long locationId, final String locationSource) {
        Location locationToChange = getLocationById(locationId);
        if (locationToChange == null) {
            return;
        }
        String locationToChangeLocationSource = locationToChange.getLocationSource();
        if ((locationToChangeLocationSource != null) && locationToChangeLocationSource.equals(locationSource)) {
            return;
        }
        appendLog(context, TAG, "updateLocationSource:entered:", locationId, ":", locationSource);
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE, locationSource);

        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,
                values,
                LocationsContract.Locations._ID + "=" + locationId,
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
        appendLog(context, TAG, "updateLocationSource:updated");
    }

