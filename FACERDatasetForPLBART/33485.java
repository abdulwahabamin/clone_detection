    /**
     * Obtains cached JSON data for the specified city.
     *
     * @param cityId Open Weather Map city ID
     * @return a string, representing JSON weather data, or null, if no cached data is stored
     */
    public Pair<String, Long> getJsonStringForWeatherInfo(int cityId) {
        Cursor cursor = getCursorWithWeatherInfo(cityId);
        if (cursor == null) {
            return null;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }

        String weatherInfoJson = getJsonStringForWeatherInfo(cursor);
        Long lastQueryTime = CityTable.CITY_NEVER_QUERIED;
        if (weatherInfoJson != null) {
            int columnIndexForLastQueryTime = cursor.getColumnIndexOrThrow(
                    columnNameForLastQueryTime);
            lastQueryTime = cursor.getLong(columnIndexForLastQueryTime);

            int columnIndex = cursor.getColumnIndexOrThrow(CityTable._ID);
            long rowId = cursor.getLong(columnIndex);
            setLastOverallQueryTimeToCurrentTime(rowId);
        }

        Pair<String, Long> storedWeatherInfo = Pair.create(weatherInfoJson, lastQueryTime);
        cursor.close();
        return storedWeatherInfo;
    }

