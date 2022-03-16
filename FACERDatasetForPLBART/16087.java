    private SQLiteDatabase getReadableDb() {
        if(readableDb.isOpen()) {
            return readableDb;
        } else {
            readableDb = openHelper.getReadableDatabase();
            return readableDb;
        }
    }

