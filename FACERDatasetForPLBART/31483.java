    @Override
    public void renderCityWeather(WeatherEntity entity) {
        if (entity != null) {
            setToolbarCity(entity.getCityName());
            mCityWeatherAdapter.setWeatherEntity(entity);
            startAnimation(entity);
        }
    }

