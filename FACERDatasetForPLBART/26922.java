    private OrmWeather loadSingleForecastFromDb(long cityId) {
        OrmWeatherDao weatherDao = daoSession.getOrmWeatherDao();
        List<OrmWeather> forecast = weatherDao.queryBuilder()
                .where(OrmWeatherDao.Properties.City_id.eq(cityId))
                .orderAsc(OrmWeatherDao.Properties.Dt)
                .limit(1)
                .build()
                .list();
        if (forecast.size() < 1) {
            return null;
        } else {
            return forecast.get(0);
        }
    }

