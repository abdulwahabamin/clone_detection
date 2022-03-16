    public Long getLocationIdByCoordinates(float lat, float lon) {

        float latLow = lat - 0.01f;
        float latHigh = lat + 0.01f;
        float lonLow = lon - 0.01f;
        float lonHigh = lon + 0.01f;
        String latLowTxt = String.valueOf(latLow).replace(",", ".");
        String latHighTxt = String.valueOf(latHigh).replace(",", ".");
        String lonLowTxt = String.valueOf(lonLow).replace(",", ".");
        String lonHighTxt = String.valueOf(lonHigh).replace(",", ".");

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                LocationsContract.Locations._ID
        };

        Cursor cursor = null;
        try {
            cursor = db.query(
                    LocationsContract.Locations.TABLE_NAME,
                    projection,
                    LocationsContract.Locations.COLUMN_NAME_LATITUDE +
                            ">? and " +
                            LocationsContract.Locations.COLUMN_NAME_LATITUDE +
                            "<? and " +
                            LocationsContract.Locations.COLUMN_NAME_LONGITUDE +
                            ">? and " +
                            LocationsContract.Locations.COLUMN_NAME_LONGITUDE +
                            "<?",
                    new String[] {latLowTxt, latHighTxt, lonLowTxt, lonHighTxt},
                    null,
                    null,
                    null
            );

            if (!cursor.moveToNext()) {
                return null;
            }
            return cursor.getLong(cursor.getColumnIndexOrThrow(LocationsContract.Locations._ID));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

