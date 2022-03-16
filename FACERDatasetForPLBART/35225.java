    @Override
    public void getWeatherDataFromCity(String cityName, GetWeatherCallBack callBack) throws Exception {
        List<WeatherEntity> res = mWeatherDao.
                queryBuilder().
                where(WeatherEntityDao.Properties.CityName.eq(cityName)).list();
        if (isListEmpty(res)) {
            callBack.onFailure("没有该城市的天气");
        } else {
            byte[] bytes = res.get(res.size() - 1).getWeather();
            callBack.onSuccess(convertObject(bytes, HWeather.class));
        }
    }

