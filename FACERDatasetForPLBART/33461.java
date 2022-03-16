    /**
     * Obtains the web address to extract the daily weather forecast for the specified number of
     * days.
     *
     * @param cityId Open Weather Map city identification number
     * @param days   number of days that the weather should be forecast
     * @return web page containing daily weather forecast
     */
    public URL generateDailyWeatherForecastUrl(int cityId, int days) {
        return getUrl(OPEN_WEATHER_MAP_URL_PREFIX + FORECAST_DAILY + ID + cityId + COUNT + days +
                getApiKey());
    }

