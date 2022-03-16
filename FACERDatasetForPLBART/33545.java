    /**
     * Creates and embeds a new fragment of the correct type to display the obtained weather data
     * in the second pane of this activity.
     *
     * @param jsonString      JSON weather information data in textual form
     * @param weatherInfoType a type of the retrieved weather data
     */
    private void displayRetrievedDataInThisActivity(String jsonString,
                                                    WeatherInfoType weatherInfoType) {
        Fragment fragment;
        if (weatherInfoType == WeatherInfoType.CURRENT_WEATHER) {
            fragment = WeatherInfoFragment.newInstance(weatherInfoType, null, jsonString);
        } else {
            fragment = WeatherForecastParentFragment.newInstance(weatherInfoType, jsonString);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.weather_info_container, fragment).commit();
    }

