    public static void clearRemoteTables() {
        SQLiteDatabase libraryDb = library.openHelper.getWritableDatabase();
        libraryDb.beginTransaction();

        for(Table remoteTable : library.remoteTables) {
            libraryDb.delete(remoteTable.TABLE_NAME, null, null);
        }

        libraryDb.setTransactionSuccessful();
        libraryDb.endTransaction();
    }

