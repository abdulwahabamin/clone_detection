    /**
     * Inserts initial cities with their default values into the database.
     *
     * @see com.haringeymobile.ukweather.data.InitialCity
     */
    private static void insertInitialData(SQLiteDatabase database) {
        for (InitialCity city : InitialCity.values()) {
            ContentValues newValues = new ContentValues();
            newValues.put(COLUMN_CITY_ID, city.getOpenWeatherMapId());
            newValues.put(COLUMN_NAME, city.getDisplayName());
            newValues.put(COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER,
                    CITY_NEVER_QUERIED);
            newValues.putNull(COLUMN_CACHED_JSON_CURRENT);
            putInitialDataForVersion2(newValues);
            database.insert(TABLE_CITIES, null, newValues);
        }
    }

