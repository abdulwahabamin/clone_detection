    @MainThread
    public void saveWeatherAsync(final String cityId, final StatusDataResource<WeatherData> statusDataResource) {
        mWeatherWorkHandler.post(new Runnable() {
            @Override
            public void run() {
                updateWeather(cityId,statusDataResource);
            }
        });
    }

