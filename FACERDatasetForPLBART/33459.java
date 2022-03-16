    /**
     * Obtains the web address to extract the list of locations matching the provided query.
     *
     * @param query user provided city search query
     * @return web page with the list of cities
     */
    public URL getAvailableCitiesListUrl(String query) {
        return getUrl(OPEN_WEATHER_MAP_URL_PREFIX + FIND_QUERY + query + LIKE + getApiKey());
    }

