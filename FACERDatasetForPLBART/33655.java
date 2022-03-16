    /**
     * Displays weather temperature, pressure, and humidity.
     *
     * @param weatherInformation various parameters describing weather
     */
    private void displayWeatherNumericParametersText(WeatherInformation weatherInformation) {
        weatherInformationDisplayer.displayWeatherNumericParametersText(weatherInformation,
                temperatureTextView, pressureTextView, humidityTextView);
    }

