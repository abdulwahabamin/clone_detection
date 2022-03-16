    /**
     * Removes the specified city record from the {@link
     * com.haringeymobile.ukweather.database.CityTable}.
     *
     * @param cityId Open Weather Map city ID
     */
    void deleteCity(int cityId) {
        context.getContentResolver().delete(
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
                CityTable.COLUMN_CITY_ID + "=?",
                new String[]{Integer.toString(cityId)});
    }

