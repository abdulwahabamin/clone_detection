    /**
     * Obtains a list of city names satisfying the user's search query.
     *
     * @param result a city search response, containing found cities and related data
     * @return a list of city names (with coordinates)
     */
    private ArrayList<String> getFoundCityNames(SearchResponseForFindQuery result) {
        ArrayList<String> foundCityNames = new ArrayList<>();
        List<CityCurrentWeather> cities = result.getCities();
        for (CityCurrentWeather city : cities) {
            String cityName = getCityName(city);
            foundCityNames.add(cityName);
        }
        return foundCityNames;
    }

