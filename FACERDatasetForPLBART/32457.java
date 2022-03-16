    private void updateLocation(SQLiteDatabase db, Location location, Location locationInFile) {
        ContentValues values = prepareValues(location, locationInFile);
        if (values.size() == 0) {
            return;
        }
        appendLog(
                this,
                TAG,
                "update location:", location.getId());
        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,
                values,
                LocationsContract.Locations._ID +"=" + locationInFile.getId(),
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
    }

