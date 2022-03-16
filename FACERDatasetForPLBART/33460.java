    /**
     * Obtains the web address to extract the list of locations nearby the provided geographical
     * coordinates.
     *
     * @param latitude  latitude of the location
     * @param longitude longitude of the location
     * @return web page with the list of cities
     */
    public URL getAvailableCitiesListUrlByGeographicalCoordinates(String latitude,
                                                                  String longitude) {
        return getUrl(OPEN_WEATHER_MAP_URL_PREFIX + FIND + LATITUDE + latitude + LONGITUDE
                + longitude + COUNT + RESULT_COUNT + getApiKey());
    }

