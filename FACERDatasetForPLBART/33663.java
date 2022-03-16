    /**
     * Displays weather temperature, pressure, and humidity.
     *
     * @param weatherInformation  various parameters describing weather
     * @param temperatureTextView view to display temperature
     * @param pressureTextView    view to display atmospheric pressure
     * @param humidityTextView    view to display humidity
     */
    void displayWeatherNumericParametersText(WeatherInformation weatherInformation,
                                             TextView temperatureTextView,
                                             TextView pressureTextView,
                                             TextView humidityTextView) {
        displayTemperatureText(weatherInformation, temperatureTextView);
        displayAtmosphericPressureText(weatherInformation, pressureTextView);
        displayHumidity(weatherInformation, humidityTextView);
    }

