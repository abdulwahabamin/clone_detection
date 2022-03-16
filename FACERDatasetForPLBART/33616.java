    /**
     * Obtains a new fragment to display weather forecast.
     *
     * @param weatherInfoType a type of weather forecast
     * @param jsonString      textual representation of JSON weather forecast data
     * @return a fragment to display the weather forecast in a view pager
     */
    public static WeatherForecastParentFragment newInstance(WeatherInfoType weatherInfoType,
                                                            String jsonString) {
        WeatherForecastParentFragment fragment = new WeatherForecastParentFragment();
        Bundle args = new Bundle();
        args.putParcelable(WEATHER_INFORMATION_TYPE, weatherInfoType);
        args.putString(WEATHER_INFO_JSON_STRING, jsonString);
        fragment.setArguments(args);
        return fragment;
    }

