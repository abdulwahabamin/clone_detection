    /**
     * Prepares the "Cities" table for alteration, and inserts the new columns;
     * this is required to upgrade the database from version 1.
     */
    private static void alterCityTable(SQLiteDatabase database) {
        String RENAME_ORIGINAL_TABLE = "ALTER TABLE " + TABLE_CITIES
                + " RENAME TO " + TABLE_TEMP;
        String COPY_OLD_TABLE_TO_NEW_TABLE = "INSERT INTO " + TABLE_CITIES
                + "(" + COLUMN_CITY_ID + ", " + COLUMN_NAME + ", "
                + COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER + ", "
                + COLUMN_CACHED_JSON_CURRENT + ") SELECT " + COLUMN_CITY_ID
                + ", " + COLUMN_NAME + ", "
                + COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER_VERSION_1 + ", "
                + COLUMN_CACHED_JSON_CURRENT_VERSION_1 + " FROM " + TABLE_TEMP
                + ";";

        database.execSQL(RENAME_ORIGINAL_TABLE);
        database.execSQL(TABLE_CREATE);
        database.execSQL(COPY_OLD_TABLE_TO_NEW_TABLE);
        database.execSQL("DROP TABLE " + TABLE_TEMP);

        insertInitialWeatherForecastValues(database);
    }

