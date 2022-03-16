    /**
     * Inserts a new current weather record for the specified city.
     *
     * @param cityId         Open Weather Map city ID
     * @param cityName       Open Weather Map city name
     * @param currentWeather Json string for the current city weather
     */
    private void insertNewCityWithCurrentWeather(int cityId, String cityName, String
            currentWeather) {
        ContentValues newValues = new ContentValues();
        newValues.put(CityTable.COLUMN_CITY_ID, cityId);
        newValues.put(CityTable.COLUMN_NAME, cityName);
        long currentTime = System.currentTimeMillis();
        newValues.put(CityTable.COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER, currentTime);
        newValues.put(CityTable.COLUMN_ORDERING_VALUE, currentTime);
        newValues.put(CityTable.COLUMN_CACHED_JSON_CURRENT, currentWeather);
        newValues.put(CityTable.COLUMN_LAST_QUERY_TIME_FOR_DAILY_WEATHER_FORECAST,
                CityTable.CITY_NEVER_QUERIED);
        newValues.putNull(CityTable.COLUMN_CACHED_JSON_DAILY_FORECAST);
        newValues.put(CityTable.COLUMN_LAST_QUERY_TIME_FOR_THREE_HOURLY_WEATHER_FORECAST,
                CityTable.CITY_NEVER_QUERIED);
        newValues.putNull(CityTable.COLUMN_CACHED_JSON_THREE_HOURLY_FORECAST);
        context.getContentResolver().insert(WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
                newValues);
    }

