    public List<Location> getAllRows() {

        List<Location> result = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                LocationsContract.Locations.COLUMN_NAME_ADDRESS,
                LocationsContract.Locations._ID,
                LocationsContract.Locations.COLUMN_NAME_LONGITUDE,
                LocationsContract.Locations.COLUMN_NAME_LATITUDE,
                LocationsContract.Locations.COLUMN_NAME_ORDER_ID,
                LocationsContract.Locations.COLUMN_NAME_LOCALE,
                LocationsContract.Locations.COLUMN_NAME_LOCATION_NICKNAME,
                LocationsContract.Locations.COLUMN_NAME_LOCATION_ACCURACY,
                LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS,
                LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE,
                LocationsContract.Locations.COLUMN_NAME_ENABLED,
                LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND
        };

        String sortOrder = LocationsContract.Locations.COLUMN_NAME_ORDER_ID;

        Cursor cursor = null;
        try {
            cursor = db.query(
                LocationsContract.Locations.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
            );

            while (cursor.moveToNext()) {

                byte[] cachedAddressBytes = cursor.getBlob(
                        cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_ADDRESS));
                Address address = null;
                if (cachedAddressBytes != null) {
                    address = getAddressFromBytes(cachedAddressBytes);
                }

                long itemId = cursor.getInt(cursor.getColumnIndexOrThrow(LocationsContract.Locations._ID));
                double longitude = cursor.getDouble(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LONGITUDE));
                double latitude = cursor.getDouble(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LATITUDE));
                int orderId = cursor.getInt(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_ORDER_ID));
                String locale = cursor.getString(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LOCALE));
                String nickname = cursor.getString(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LOCATION_NICKNAME));
                float accuracy = cursor.getFloat(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LOCATION_ACCURACY));
                long locationUpdateTime = cursor.getLong(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LAST_UPDATE_TIME_IN_MS));
                String locationSource = cursor.getString(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_LOCATION_UPDATE_SOURCE));
                boolean addressFound = 1 == cursor.getInt(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_ADDRESS_FOUND));
                boolean enabled = 1 == cursor.getInt(cursor.getColumnIndexOrThrow(LocationsContract.Locations.COLUMN_NAME_ENABLED));

                if (locale == null) {
                    locale = PreferenceUtil.getLanguage(context);
                }

                result.add(new Location(
                        itemId,
                        orderId,
                        nickname,
                        locale,
                        longitude,
                        latitude,
                        accuracy,
                        locationSource,
                        locationUpdateTime,
                        addressFound,
                        enabled,
                        address));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

