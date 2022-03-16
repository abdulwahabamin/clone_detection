    /** Creates underlying database table using DAOs. */
    public static void createAllTables(Database db, boolean ifNotExists) {
        CityEntityDao.createTable(db, ifNotExists);
        LoveCityEntityDao.createTable(db, ifNotExists);
        ProvinceEntityDao.createTable(db, ifNotExists);
        WeatherEntityDao.createTable(db, ifNotExists);
    }

