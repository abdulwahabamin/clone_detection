    /**
     * Obtains the city name, and fills the JSON string list with the extracted three hourly
     * forecast JSON strings.
     *
     * @param jsonString textual representation of JSON 5 days three hourly weather forecast data
     * @param gson       a converter between JSON strings and Java objects
     */
    private void extractThreeHourlyForecastJsonData(String jsonString, Gson gson) {
        SearchResponseForThreeHourlyForecastQuery searchResponseForThreeHourlyForecastQuery = gson
                .fromJson(jsonString, SearchResponseForThreeHourlyForecastQuery.class);
        CityInfo cityInfo = searchResponseForThreeHourlyForecastQuery.getCityInfo();
        // It appears that for some cities the query returns with city information missing, in
        // which case cityInfo will be null
        getCityName(cityInfo);
        List<CityThreeHourlyWeatherForecast> threeHourlyForecasts =
                searchResponseForThreeHourlyForecastQuery.getThreeHourlyWeatherForecasts();
        for (CityThreeHourlyWeatherForecast forecast : threeHourlyForecasts) {
            jsonStringsForChildFragments.add(gson.toJson(forecast));
        }
    }

