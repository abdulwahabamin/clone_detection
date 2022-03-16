    /**
     * Obtains a cursor over the specified city weather information record in
     * the {@link com.haringeymobile.ukweather.database.CityTable}.
     *
     * @param cityId Open Weather Map city ID
     */
    private Cursor getCursorWithWeatherInfo(int cityId) {
        if (context == null) {
            return null;
        }
        return context.getContentResolver().query(
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
                new String[]{CityTable._ID, columnNameForLastQueryTime,
                        columnNameForJsonString,
                        CityTable.COLUMN_ORDERING_VALUE},
                CityTable.COLUMN_CITY_ID + "=?",
                new String[]{Integer.toString(cityId)}, null);
    }

