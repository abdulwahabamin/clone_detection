    public static DaoSession getDaoSession() {
        if (daoMaster == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getAppContext(), ENCRYPTED ?
                    "weather-db-encrypted" : "weather-db");
            Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
            daoMaster = new DaoMaster(db);
            daoSession = new DaoMaster(db).newSession();
        }
        return daoMaster.newSession();
    }

