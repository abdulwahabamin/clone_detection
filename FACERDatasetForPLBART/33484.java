    /**
     * Creates {@link android.content.ContentValues} with the added time and weather information
     * values.
     *
     * @param jsonString JSON string for the weather information of some kind
     */
    private ContentValues createContentValuesWithDateAndWeatherJsonString(String jsonString) {
        ContentValues newValues = new ContentValues();
        long currentTime = System.currentTimeMillis();
        newValues.put(columnNameForLastQueryTime, currentTime);
        newValues.put(CityTable.COLUMN_ORDERING_VALUE, currentTime);
        newValues.put(columnNameForJsonString, jsonString);
        return newValues;
    }

