    /**
     * Obtains the city name.
     *
     * @param cityInfo information about the queried city
     */
    private void getCityName(CityInfo cityInfo) {
        // TODO The city can be renamed by a user, so we should query the database for the name
        // It appears that for some cities the query returns with city information missing, in
        // which case cityInfo will be null
        cityName = cityInfo == null ? CITY_NAME_NOT_KNOWN : cityInfo.getCityName();
    }

