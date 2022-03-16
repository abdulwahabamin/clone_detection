    /**
     * Performs transactions required to upgrade the database from version 1.
     */
    private static void alterDatabaseVersion_1(SQLiteDatabase database) {
        database.beginTransaction();
        try {
            alterCityTable(database);
            database.setTransactionSuccessful();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error upgrading database from version 1");
        } finally {
            database.endTransaction();
        }
    }

