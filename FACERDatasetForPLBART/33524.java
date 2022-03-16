    /**
     * Obtains the city name to be displayed in the found city list.
     *
     * @param cityCurrentWeather weather and other information about the city
     * @return a city name (with latitude and longitude)
     */
    private String getCityName(CityCurrentWeather cityCurrentWeather) {
        Coordinates cityCoordinates = cityCurrentWeather.getCoordinates();
        return cityCurrentWeather.getCityName() + ", "
                + cityCurrentWeather.getSystemParameters().getCountry() + "\n("
                + MiscMethods.formatDoubleValue(cityCoordinates.getLatitude(), 2)
                + ", "
                + MiscMethods.formatDoubleValue(cityCoordinates.getLongitude(), 2)
                + ")";
    }

