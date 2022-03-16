    private List<OrmWeather> loadForecastFromDb(int cityId) {
        OrmWeatherDao weatherDao = daoSession.getOrmWeatherDao();
        return weatherDao.queryBuilder()
                .where(OrmWeatherDao.Properties.City_id.eq(cityId))
                .build()
                .list();
    }

