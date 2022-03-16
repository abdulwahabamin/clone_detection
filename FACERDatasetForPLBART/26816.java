    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        ormCityDaoConfig = daoConfigMap.get(OrmCityDao.class).clone();
        ormCityDaoConfig.initIdentityScope(type);

        ormWeatherDaoConfig = daoConfigMap.get(OrmWeatherDao.class).clone();
        ormWeatherDaoConfig.initIdentityScope(type);

        ormCityDao = new OrmCityDao(ormCityDaoConfig, this);
        ormWeatherDao = new OrmWeatherDao(ormWeatherDaoConfig, this);

        registerDao(OrmCity.class, ormCityDao);
        registerDao(OrmWeather.class, ormWeatherDao);
    }

