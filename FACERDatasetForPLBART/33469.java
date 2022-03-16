    /**
     * Inserts new columns into the "Cities" table.
     */
    private static void insertInitialWeatherForecastValues(
            SQLiteDatabase database) {
        ContentValues initialForecastValues = new ContentValues();
        putInitialDataForVersion2(initialForecastValues);
        database.insert(TABLE_CITIES, null, initialForecastValues);
    }

