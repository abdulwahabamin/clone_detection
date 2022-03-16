    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORM_WEATHER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CITY_ID\" INTEGER," + // 1: city_id
                "\"CITY_NAME\" TEXT," + // 2: city_name
                "\"DT\" INTEGER," + // 3: dt
                "\"TEMP\" REAL," + // 4: temp
                "\"TEMP_MIN\" REAL," + // 5: temp_min
                "\"TEMP_MAX\" REAL," + // 6: temp_max
                "\"PRESSURE\" REAL," + // 7: pressure
                "\"HUMIDITY\" INTEGER," + // 8: humidity
                "\"CLOUDS\" INTEGER," + // 9: clouds
                "\"WIND_SPEED\" REAL," + // 10: wind_speed
                "\"WIND_DIR\" TEXT," + // 11: wind_dir
                "\"RAIN\" INTEGER," + // 12: rain
                "\"SNOW\" INTEGER," + // 13: snow
                "\"ICON\" TEXT," + // 14: icon
                "\"CONDITION_CODE\" INTEGER," + // 15: condition_code
                "\"CONDITION_TEXT\" TEXT," + // 16: condition_text
                "\"IS_DAY\" INTEGER);"); // 17: is_day
    }

