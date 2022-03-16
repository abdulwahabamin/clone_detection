    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        MiscMethods.log("Upgrading database from version " + oldVersion
                + " to version " + newVersion);
        if (oldVersion == 1 && newVersion > 1) {
            alterDatabaseVersion_1(database);
        } else {
            database.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
            onCreate(database);
        }
    }

