    /**
     * Builds the URL for the OpenWeatherMap API that can be used to query the weather for a single
     * city.
     *
     * @param cityId    The ID of the city to get the data for.
     * @param useMetric If set to true, temperature values will be in Celsius.
     * @return Returns the URL that can be used to query the weather for the given city.
     */
    protected String getUrlForQueryingSingleCity(int cityId, boolean useMetric) {
        return String.format(
                "%sweather?id=%s%s&appid=%s",
                OwmApiData.BASE_URL,
                cityId,
                (useMetric) ? "&units=metric" : "",
                OwmApiData.getAPI_KEY()
        );
    }

