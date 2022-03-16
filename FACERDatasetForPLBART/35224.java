    @Override
    public boolean isExistInCityWeather(String cityName) {
        List<WeatherEntity> res = mWeatherDao.queryBuilder().
                where(WeatherEntityDao.Properties.CityName.eq(cityName)).
                limit(1).list();
        return !isListEmpty(res);
    }

