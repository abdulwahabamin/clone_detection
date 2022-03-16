    /**
     * Obtains the kind of weather information associated with the view.
     *
     * @param view the clicked view (button)
     * @return requested weather information type
     */
    private WeatherInfoType getRequestedWeatherInfoType(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.city_current_weather_button:
                return WeatherInfoType.CURRENT_WEATHER;
            case R.id.city_daily_weather_forecast_button:
                return WeatherInfoType.DAILY_WEATHER_FORECAST;
            case R.id.city_three_hourly_weather_forecast_button:
                return WeatherInfoType.THREE_HOURLY_WEATHER_FORECAST;
            default:
                throw new IllegalArgumentException("Not supported view ID: " + viewId);
        }
    }

