    /**
     * Updates current weather record for the specified city if it already exists in the database,
     * otherwise inserts a new record.
     *
     * @param cityId         Open Weather Map city ID
     * @param cityName       Open Weather Map city name
     * @param currentWeather Json string for the current city weather
     */
    void updateOrInsertCityWithCurrentWeather(int cityId, String cityName, String currentWeather) {
        if (!CityTable.COLUMN_CACHED_JSON_CURRENT.equals(columnNameForJsonString)) {
            throw new IllegalStateException(
                    "This method is expected to deal with current weather information only");
        }

        Cursor cursor = getCursorWithCityId(cityId);
        if (cursor == null) {
            return;
        }
        boolean cityIdExists = cursor.moveToFirst();
        if (cityIdExists) {
            Uri rowUri = getRowUri(cursor);
            ContentValues newValues =
                    createContentValuesWithDateAndWeatherJsonString(currentWeather);
            context.getContentResolver().update(rowUri, newValues, null, null);
            cursor.close();
        } else {
            insertNewCityWithCurrentWeather(cityId, cityName, currentWeather);
        }
    }

