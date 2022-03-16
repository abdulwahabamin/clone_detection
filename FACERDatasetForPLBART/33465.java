    /**
     * Puts default values for the new columns in databse version 2 into the
     * provided {@link android.content.ContentValues}.
     *
     * @param newValues values for the new record to be inserted into the database
     */
    private static void putInitialDataForVersion2(ContentValues newValues) {
        newValues.put(COLUMN_LAST_QUERY_TIME_FOR_DAILY_WEATHER_FORECAST,
                CITY_NEVER_QUERIED);
        newValues.putNull(COLUMN_CACHED_JSON_DAILY_FORECAST);
        newValues.put(COLUMN_LAST_QUERY_TIME_FOR_THREE_HOURLY_WEATHER_FORECAST,
                CITY_NEVER_QUERIED);
        newValues.putNull(COLUMN_CACHED_JSON_THREE_HOURLY_FORECAST);
        newValues.put(COLUMN_ORDERING_VALUE, CITY_NEVER_QUERIED);
    }

