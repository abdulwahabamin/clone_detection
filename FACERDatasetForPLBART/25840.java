    @Override
    protected void onCreate() {

        mGetWeatherStatus = new MutableLiveData<>();

        WeatherRepository.getInstance().getWeatherObserver().observe(this, new Observer<StatusDataResource<WeatherData>>() {
            @Override
            public void onChanged(@Nullable StatusDataResource<WeatherData> statusDataResource) {

                try {
                    parseWeather(statusDataResource.data);
                }catch (Exception e) {
                    LogHelper.error(TAG,"parse weather date error %s",e);
                }

                mGetWeatherStatus.setValue(statusDataResource.status);
            }

        });
    }

