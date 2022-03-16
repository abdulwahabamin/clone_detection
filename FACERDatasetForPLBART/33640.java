    /**
     * Determines and sets the toolbar text.
     *
     * @param weatherInfoType a kind of weather information to be displayed on the screen
     * @param toolbar         toolbar for this activity
     */
    private void setToolbarTitle(WeatherInfoType weatherInfoType, Toolbar toolbar) {
        String title = getResources().getString(weatherInfoType.getLabelResourceId());
        toolbar.setTitle(title);
        if (weatherInfoType == WeatherInfoType.THREE_HOURLY_WEATHER_FORECAST) {
            updateTitleWithCityNameIfNecessary(toolbar, title);
        }
    }

