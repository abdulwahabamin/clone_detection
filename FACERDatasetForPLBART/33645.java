    /**
     * Creates and sets the required weather information fragment.
     *
     * @param weatherInfoType requested weather information type
     * @param cityName        the name of the city for which the weather information was
     *                        requested and obtained
     * @param jsonString      JSON weather information data in textual form
     * @return a fragment to display the requested weather information
     */
    public static WeatherInfoFragment newInstance(WeatherInfoType weatherInfoType, String cityName,
                                                  String jsonString) {
        WeatherInfoFragment weatherInfoFragment = createWeatherInfoFragment(weatherInfoType);
        Bundle args = getArgumentBundle(cityName, jsonString);
        weatherInfoFragment.setArguments(args);
        return weatherInfoFragment;
    }

