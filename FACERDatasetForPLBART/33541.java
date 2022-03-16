    /**
     * Updates the current weather record for the city if it already exists in the database,
     * otherwise inserts a new record.
     *
     * @param cityId                   Open Weather Map ID for the city
     * @param cityName                 the name as provided by the Open Weather Map
     * @param currentWeatherJsonString JSON current weather data
     */
    private void insertNewRecordOrUpdateCity(int cityId, String cityName,
                                             String currentWeatherJsonString) {
        Intent intent = new Intent(this, GeneralDatabaseService.class);
        intent.setAction(GeneralDatabaseService.ACTION_INSERT_OR_UPDATE_CITY_RECORD);
        intent.putExtra(CITY_ID, cityId);
        intent.putExtra(CITY_NAME, cityName);
        intent.putExtra(WEATHER_INFO_JSON_STRING, currentWeatherJsonString);
        startService(intent);
    }

