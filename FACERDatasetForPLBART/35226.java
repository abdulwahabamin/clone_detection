    @Override
    public void getWeatherEntity(String cityName, GetWeatherEntityCallBack callBack) {
        List<WeatherEntity> res = mWeatherDao.queryBuilder().
                where(WeatherEntityDao.Properties.CityName.eq(cityName)).list();
        if (isListEmpty(res)) {
            callBack.onFailure("没有该城市的天气数�?�");
        } else {
            callBack.onSuccess(res.get(res.size() - 1));
        }
    }

