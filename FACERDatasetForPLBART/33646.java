    /**
     * Creates a fragment, corresponding to the requested weather information type.
     *
     * @param weatherInfoType requested weather information type
     * @return a correct type of weather information fragment
     */
    private static WeatherInfoFragment createWeatherInfoFragment(WeatherInfoType weatherInfoType) {
        switch (weatherInfoType) {
            case CURRENT_WEATHER:
                return new WeatherCurrentInfoFragment();
            case DAILY_WEATHER_FORECAST:
                return new WeatherDailyWeatherForecastChildFragment();
            case THREE_HOURLY_WEATHER_FORECAST:
                return new WeatherThreeHourlyForecastChildSwipeFragment();
            default:
                throw new IllegalWeatherInfoTypeArgumentException(weatherInfoType);
        }
    }

