    /**
     * Updates the specified city with new weather data.
     *
     * @param cityId     Open Weather Map city ID
     * @param jsonString JSON string for the weather information of some kind
     */
    void updateWeatherInfo(int cityId, String jsonString) {
        Cursor cursor = getCursorWithWeatherInfo(cityId);
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return;
        }
        Uri rowUri = getRowUri(cursor);
        ContentValues newValues = createContentValuesWithDateAndWeatherJsonString(jsonString);
        context.getContentResolver().update(rowUri, newValues, null, null);
        cursor.close();
    }

