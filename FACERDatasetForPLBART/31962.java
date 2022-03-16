    public void updateLocale(final long locationId, final String locale) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationsContract.Locations.COLUMN_NAME_LOCALE, locale);
        db.updateWithOnConflict(
                LocationsContract.Locations.TABLE_NAME,values,
                LocationsContract.Locations._ID +"=" + locationId,
                null,
                SQLiteDatabase.CONFLICT_IGNORE);
    }

