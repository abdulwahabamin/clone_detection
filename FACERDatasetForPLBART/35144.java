    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cityEntityDaoConfig = daoConfigMap.get(CityEntityDao.class).clone();
        cityEntityDaoConfig.initIdentityScope(type);

        loveCityEntityDaoConfig = daoConfigMap.get(LoveCityEntityDao.class).clone();
        loveCityEntityDaoConfig.initIdentityScope(type);

        provinceEntityDaoConfig = daoConfigMap.get(ProvinceEntityDao.class).clone();
        provinceEntityDaoConfig.initIdentityScope(type);

        weatherEntityDaoConfig = daoConfigMap.get(WeatherEntityDao.class).clone();
        weatherEntityDaoConfig.initIdentityScope(type);

        cityEntityDao = new CityEntityDao(cityEntityDaoConfig, this);
        loveCityEntityDao = new LoveCityEntityDao(loveCityEntityDaoConfig, this);
        provinceEntityDao = new ProvinceEntityDao(provinceEntityDaoConfig, this);
        weatherEntityDao = new WeatherEntityDao(weatherEntityDaoConfig, this);

        registerDao(CityEntity.class, cityEntityDao);
        registerDao(LoveCityEntity.class, loveCityEntityDao);
        registerDao(ProvinceEntity.class, provinceEntityDao);
        registerDao(WeatherEntity.class, weatherEntityDao);
    }

