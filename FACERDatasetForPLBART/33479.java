    /**
     * Obtains a cursor over the specified city record ID in the
     * {@link com.haringeymobile.ukweather.database.CityTable}.
     *
     * @param cityId Open Weather Map city ID
     */
    private Cursor getCursorWithCityId(int cityId) {
        if (context == null) {
            return null;
        }
        return context.getContentResolver().query(
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
                new String[]{CityTable._ID, CityTable.COLUMN_CITY_ID},
                CityTable.COLUMN_CITY_ID + "=?",
                new String[]{Integer.toString(cityId)}, null);
    }

