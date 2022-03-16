    public static void deleteUser(String username) {
        SQLiteDatabase libraryDb = library.openHelper.getWritableDatabase();
        libraryDb.beginTransaction();

        for(Table remoteTable : library.remoteTables) {
            libraryDb.delete(remoteTable.TABLE_NAME,
                    Table.RemoteColumns.REMOTE_USERNAME + "=?",
                    new String[]{username});
        }

        libraryDb.setTransactionSuccessful();
        libraryDb.endTransaction();
    }

