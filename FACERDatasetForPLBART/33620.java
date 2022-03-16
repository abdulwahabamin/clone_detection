    /**
     * Obtains the city name, and fills the JSON string list with the extracted daily forecast
     * JSON strings.
     *
     * @param jsonString textual representation of JSON 16 day daily weather forecast data
     * @param gson       a converter between JSON strings and Java objects
     */
    private void extractDailyForecastJsonData(String jsonString, Gson gson) {
        SearchResponseForDailyForecastQuery searchResponseForDailyForecastQuery = gson.fromJson(
                jsonString, SearchResponseForDailyForecastQuery.class);
        CityInfo cityInfo = searchResponseForDailyForecastQuery.getCityInfo();
        getCityName(cityInfo);

        List<CityDailyWeatherForecast> dailyForecasts = searchResponseForDailyForecastQuery
                .getDailyWeatherForecasts();
        for (CityDailyWeatherForecast forecast : dailyForecasts) {
            jsonStringsForChildFragments.add(gson.toJson(forecast));
        }
    }

