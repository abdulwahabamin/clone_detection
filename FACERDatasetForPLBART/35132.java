    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(Database db, boolean ifExists) {
        CityEntityDao.dropTable(db, ifExists);
        LoveCityEntityDao.dropTable(db, ifExists);
        ProvinceEntityDao.dropTable(db, ifExists);
        WeatherEntityDao.dropTable(db, ifExists);
    }

