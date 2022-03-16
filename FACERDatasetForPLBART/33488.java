    /**
     * Changes the name of the specified city in the {@link
     * com.haringeymobile.ukweather.database.CityTable}.
     *
     * @param cityId  Open Weather Map city ID
     * @param newName the new (user-chosen) name for the city
     */
    void renameCity(int cityId, String newName) {
        ContentValues newValues = new ContentValues();
        newValues.put(CityTable.COLUMN_NAME, newName);
        context.getContentResolver().update(
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS, newValues,
                CityTable.COLUMN_CITY_ID + "=?",
                new String[]{Integer.toString(cityId)});
    }

