    @Override
    protected void onCreate() {
        mFollowedWeather.setValue(new CopyOnWriteArrayList<FollowedCityData>());
        CoreManager.getImpl(IWeatherProvider.class).getWeatherData().observe(this, new Observer<StatusDataResource<WeatherData>>() {
            @Override
            public void onChanged(@Nullable StatusDataResource<WeatherData> statusDataResource) {
                if(statusDataResource.isSucceed()) {
                    onWeather(statusDataResource.data);
                }
            }

        });
    }

