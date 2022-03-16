    private void updateWeather(Weather weather) throws SQLException {

        weatherDaoOperation.update(weather);
        apiDaoOperation.update(weather.getAirQualityLive());

        //先删除旧数�?�
        DeleteBuilder<WeatherForecast, Long> forecastDeleteBuilder = forecastDaoOperation.deleteBuilder();
        forecastDeleteBuilder.where().eq(WeatherForecast.CITY_ID_FIELD_NAME, weather.getCityId());
        PreparedDelete<WeatherForecast> forecastPrepared = forecastDeleteBuilder.prepare();
        forecastDaoOperation.delete(forecastPrepared);
        //�?�?�入新数�?�
        for (WeatherForecast weatherForecast : weather.getWeatherForecasts()) {
            forecastDaoOperation.create(weatherForecast);
        }

        //先删除旧数�?�
        DeleteBuilder<LifeIndex, Long> lifeIndexDeleteBuilder = lifeIndexesDaoOperation.deleteBuilder();
        lifeIndexDeleteBuilder.where().eq(LifeIndex.CITY_ID_FIELD_NAME, weather.getCityId());
        PreparedDelete<LifeIndex> lifeIndexPrepared = lifeIndexDeleteBuilder.prepare();
        lifeIndexesDaoOperation.delete(lifeIndexPrepared);
        //�?�?�入新数�?�
        for (LifeIndex index : weather.getLifeIndexes()) {
            lifeIndexesDaoOperation.create(index);
        }
        realTimeDaoOperation.update(weather.getWeatherLive());
    }

