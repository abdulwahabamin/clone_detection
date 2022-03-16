    public DaoMaster(Database db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(CityEntityDao.class);
        registerDaoClass(LoveCityEntityDao.class);
        registerDaoClass(ProvinceEntityDao.class);
        registerDaoClass(WeatherEntityDao.class);
    }

