    private List<OrmWeather> loadForecastFromDb(int cityId, Date date) {
        OrmWeatherDao weatherDao = daoSession.getOrmWeatherDao();
        List<OrmWeather> forecast = weatherDao.queryBuilder()
                .where(OrmWeatherDao.Properties.Dt.between(getStartOfDayInMillis(date),
                        getEndOfDayInMillis(date)),
                        OrmWeatherDao.Properties.City_id.eq(cityId))
                .build().list();
        Utility.sortWeatherHour(forecast);
        return forecast;
    }

