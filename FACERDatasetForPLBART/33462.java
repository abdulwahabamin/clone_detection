    /**
     * Obtains the web address to extract the three hourly weather forecast for the specified city.
     *
     * @param cityId Open Weather Map city identification number
     * @return web page containing three hourly weather forecast
     */
    public URL generateThreeHourlyWeatherForecastUrl(int cityId) {
        return getUrl(OPEN_WEATHER_MAP_URL_PREFIX + FORECAST + ID + cityId + getApiKey());
    }

