    private void initializeLocalLibrary() {
        SQLiteDatabase libraryDb = openHelper.getWritableDatabase();

        libraryDb.beginTransaction();

        for(Table table : tables) {
            table.initialize(libraryDb);
        }

        libraryDb.setTransactionSuccessful();
        libraryDb.endTransaction();
    }

