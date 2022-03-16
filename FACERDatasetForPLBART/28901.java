    /**
     * Converts the response to JSON and updates the database so that the latest weather data are
     * displayed.
     *
     * @param response The response of the HTTP request.
     */
    @Override
    public void processSuccessScenario(String response) {
        IDataExtractor extractor = new OwmDataExtractor();
        // City was found => can now be extracted
        if (extractor.wasCityFound(response)) {
            CurrentWeatherData weatherData = extractor.extractCurrentWeatherData(response);
            int cityId = extractor.extractCityID(response);
            // Error case :/
            if (weatherData == null || cityId == Integer.MIN_VALUE) {
                final String ERROR_MSG = context.getResources().getString(R.string.convert_to_json_error);
                Toast.makeText(context, ERROR_MSG, Toast.LENGTH_LONG).show();
            } else {
                weatherData.setCity_id(cityId);

                dbHelper.deleteCurrentWeatherByCityId(cityId);

                dbHelper.addCurrentWeather(weatherData);

                ViewUpdater.updateCurrentWeatherData(weatherData);
            }
        }
        // City was not found; sometimes this happens for OWM requests even though the city ID is
        // valid
        else {
            Toast.makeText(context, R.string.activity_main_location_not_found, Toast.LENGTH_LONG).show();
        }
    }

