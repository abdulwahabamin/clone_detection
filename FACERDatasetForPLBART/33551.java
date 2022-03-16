    /**
     * Saves the retrieved data in the database, so that it could be reused for a short period of
     * time.
     *
     * @param jsonString      Weather information data in JSON format
     * @param weatherInfoType type of the retrieved weather data
     */
    protected void saveRetrievedData(String jsonString, WeatherInfoType weatherInfoType) {
        Intent intent = new Intent(this, GeneralDatabaseService.class);
        intent.setAction(GeneralDatabaseService.ACTION_UPDATE_WEATHER_INFO);
        intent.putExtra(WEATHER_INFO_JSON_STRING, jsonString);
        intent.putExtra(WEATHER_INFORMATION_TYPE, (Parcelable) weatherInfoType);
        startService(intent);
    }

