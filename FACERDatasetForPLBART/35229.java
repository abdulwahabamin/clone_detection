    @Override
    public HWeather getLocalWeather(String cityName) {
        WeatherEntity entity = getWeatherEntity(cityName);
        if (entity == null) {
            return null;
        } else {
            return convertObject(entity.getWeather(), HWeather.class);
        }
    }

