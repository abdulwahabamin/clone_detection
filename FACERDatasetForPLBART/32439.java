    private void storeAddressToCache(Context context, ReverseGeocodingCacheDbHelper mDbHelper, double latitude, double longitude, String locale, Address address) {

        boolean useCache = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(Constants.APP_SETTINGS_LOCATION_CACHE_ENABLED, false);

        if (!useCache) {
            return;
        }

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(LocationAddressCache.COLUMN_NAME_ADDRESS, getAddressAsBytes(address));
        values.put(LocationAddressCache.COLUMN_NAME_LONGITUDE, longitude);
        values.put(LocationAddressCache.COLUMN_NAME_LATITUDE, latitude);
        values.put(LocationAddressCache.COLUMN_NAME_LOCALE, locale);
        values.put(LocationAddressCache.COLUMN_NAME_CREATED, new Date().getTime());

        long newLocationRowId = db.insert(LocationAddressCache.TABLE_NAME, null, values);

        appendLog(context, TAG, "storedAddress:", latitude, ", ", longitude, ", ", newLocationRowId, ", ", address);
    }

