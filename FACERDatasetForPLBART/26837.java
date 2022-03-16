    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORM_CITY\" (" + //
                "\"_ID\" INTEGER PRIMARY KEY ," + // 0: _id
                "\"CITY_NAME\" TEXT," + // 1: city_name
                "\"REGION\" TEXT," + // 2: region
                "\"COUNTRY\" TEXT," + // 3: country
                "\"LAT\" REAL," + // 4: lat
                "\"LON\" REAL);"); // 5: lon
    }

