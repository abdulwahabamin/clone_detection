    /**
     * Obtains the city name stored in the database.
     *
     * @param cityId Open Weather Map city ID
     * @return city name stored in the database (note that the city name provided by OWM may be
     * changed by a user)
     */
    public String findCityName(int cityId) {
        if (context == null) {
            return null;
        }
        Cursor cursor = context.getContentResolver().query(
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
                new String[]{CityTable._ID, CityTable.COLUMN_NAME},
                CityTable.COLUMN_CITY_ID + "=?",
                new String[]{Integer.toString(cityId)}, null);
        if (cursor == null) {
            return null;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        int columnIndexForCityName = cursor.getColumnIndexOrThrow(CityTable.COLUMN_NAME);
        String cityName = cursor.getString(columnIndexForCityName);
        cursor.close();
        return cityName;
    }

