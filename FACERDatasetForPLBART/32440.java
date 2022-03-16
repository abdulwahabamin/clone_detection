    private Address getResultFromCache(ReverseGeocodingCacheDbHelper mDbHelper, double latitude, double longitude, String locale) {

        new DeleteOldRows(mDbHelper).start();

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                LocationAddressCache.COLUMN_NAME_ADDRESS
        };

        double latitudeLow = latitude - 0.0001;
        double latitudeHigh = latitude + 0.0001;
        double longitudeLow = longitude - 0.0001;
        double longitudeHigh = longitude + 0.0001;

        String selection = LocationAddressCache.COLUMN_NAME_LONGITUDE + " <= ? and " +
                LocationAddressCache.COLUMN_NAME_LONGITUDE + " >= ? and " +
                LocationAddressCache.COLUMN_NAME_LATITUDE + " <= ? and " +
                LocationAddressCache.COLUMN_NAME_LATITUDE + " >= ? and " +
                LocationAddressCache.COLUMN_NAME_LOCALE + " = ? ";
        String[] selectionArgs = { String.valueOf(longitudeHigh),
                String.valueOf(longitudeLow),
                String.valueOf(latitudeHigh),
                String.valueOf(latitudeLow),
                locale };

        Cursor cursor = null;
        try {
            cursor = db.query(
                    LocationAddressCache.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );

            if (!cursor.moveToNext()) {
                cursor.close();
                return null;
            }

            byte[] cachedAddressBytes = cursor.getBlob(
                    cursor.getColumnIndexOrThrow(LocationAddressCache.COLUMN_NAME_ADDRESS));
            return ReverseGeocodingCacheDbHelper.getAddressFromBytes(cachedAddressBytes);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

