    /**
     * Displays the specified weather information on the screen.
     *
     * @param weatherInformation various parameters describing weather
     */
    public void displayWeather(WeatherInformation weatherInformation) {
        displayExtraInfo(weatherInformation);
        displayConditions(weatherInformation);
        displayWeatherNumericParametersText(weatherInformation);
        displayWindInfo(weatherInformation);
    }

