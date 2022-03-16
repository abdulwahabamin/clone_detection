    @Override
    public WeatherEntity getWeatherEntity(String cityName) {
        List<WeatherEntity> res = mWeatherDao.queryBuilder().
                where(WeatherEntityDao.Properties.CityName.eq(cityName)).list();
        if (!isListEmpty(res)) {
            return res.get(res.size() - 1);
        } else {
            return null;
        }
    }

