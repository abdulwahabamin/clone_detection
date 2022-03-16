    /**
     * Starts a new activity to display the obtained weather data.
     *
     * @param jsonString      JSON weather information data in textual form
     * @param weatherInfoType a type of the retrieved weather data
     */
    private void displayRetrievedDataInNewActivity(String jsonString,
                                                   WeatherInfoType weatherInfoType) {
        Intent intent = new Intent(this, WeatherInfoActivity.class);
        intent.putExtra(WEATHER_INFORMATION_TYPE, (Parcelable) weatherInfoType);
        intent.putExtra(WEATHER_INFO_JSON_STRING, jsonString);
        startActivityWithTransitionAnimation(intent);
    }

