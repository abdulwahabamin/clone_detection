    /**
     * Obtains cached JSON data using the specified cursor.
     *
     * @param cursor a cursor pointing to the {@link
     *               com.haringeymobile.ukweather.database.CityTable} row with the cached
     *               weather data
     * @return a string, representing JSON weather data, or null, if the cached weather data is
     * outdated
     */
    private String getJsonStringForWeatherInfo(Cursor cursor) {
        int columnIndexForWeatherInfo = cursor.getColumnIndexOrThrow(columnNameForJsonString);
        return cursor.getString(columnIndexForWeatherInfo);
    }

