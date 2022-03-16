    @Override
    public void updateCityWeather(final String cityName) throws Exception {
        if (isExistInCityWeather(cityName)) {
            WeatherEntity entity = getWeatherEntity(cityName);
            Date oldTime = entity.getUpdateTime();
            Date nowDate = convertDate(new Date());
            if (isNeedUpdate(oldTime, nowDate)) {
                isCachedDirty = true;
                HWeather weather = getWeatherDataFromCity(cityName);
                saveWeather(weather);
                LogUtils.e(TAG,"save了");
            }
        } else {
            HWeather weather = getWeatherDataFromCity(cityName);
            saveWeather(weather);
        }

    }

