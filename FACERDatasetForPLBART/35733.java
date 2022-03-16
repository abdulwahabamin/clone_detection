    public Weather queryWeather(String cityId) throws SQLException {

        return TransactionManager.callInTransaction(WeatherDatabaseHelper.getInstance(context).getConnectionSource(), () -> {
            Weather weather = weatherDaoOperation.queryForId(cityId);
            if (weather != null) {
                weather.setAirQualityLive(apiDaoOperation.queryForId(cityId));
                weather.setWeatherForecasts(forecastDaoOperation.queryForEq(WeatherForecast.CITY_ID_FIELD_NAME, cityId));
                weather.setLifeIndexes(lifeIndexesDaoOperation.queryForEq(WeatherForecast.CITY_ID_FIELD_NAME, cityId));
                weather.setWeatherLive(realTimeDaoOperation.queryForId(cityId));
            }
            return weather;
        });
    }

