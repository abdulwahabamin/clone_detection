    /**
     * Builds the URL for the OpenWeatherMap API that can be used to query the weather forecast
     * for a single city.
     *
     * @param cityId The ID of the city to get the forecast data for.
     * @return Returns the URL that can be used to query weather forecasts for the given city using
     * OpenWeatherMap.
     */
    protected String getUrlForQueryingForecast(int cityId) {
        return String.format(
                "%sforecast?id=%s&units=metric&appid=%s",
                OwmApiData.BASE_URL,
                cityId,
                OwmApiData.getAPI_KEY()
        );
    }

