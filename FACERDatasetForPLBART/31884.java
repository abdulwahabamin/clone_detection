    @Override
    public SQLiteDatabase getReadableDatabase() {
        int retryCounter = 0;
        do {
            try {
                return super.getReadableDatabase();
            } catch (SQLiteDatabaseLockedException dbLockException) {
                retryCounter++;
                if (retryCounter > GET_READABLE_DATABASE_RETRIES) {
                    return null;
                }
                try {
                    Thread.currentThread().sleep(GET_READABLE_DATABASE_WAIT_TIME_MS);
                } catch (InterruptedException e) {
                    //
                }
            }
        } while (retryCounter <= GET_READABLE_DATABASE_RETRIES);
        return null;
    }

