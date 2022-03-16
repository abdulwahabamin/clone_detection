    /**
     * Obtains the web address to extract the current weather information for the
     * provided city.
     *
     * @param cityId Open Weather Map city identification number
     * @return web page containing current weather information
     */
    public URL generateCurrentWeatherByCityIdUrl(int cityId) {
        return getUrl(OPEN_WEATHER_MAP_URL_PREFIX + WEATHER + ID + cityId + getApiKey());
    }

