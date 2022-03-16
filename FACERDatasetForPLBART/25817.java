    @Override
    protected void initDataObserver() {

        mWeatherModel = ModelProvider.getModel(this,WeatherModel.class);

        mWeatherModel.getGetWeatherStatus().observe(this, new Observer<StatusDataResource.Status>() {
            @Override
            public void onChanged(@Nullable final StatusDataResource.Status status) {
                if(StatusDataResource.Status.LOADING.equals(status)) {
                    startRefresh();
                    updateBaseWeatherInfo(mWeatherModel.getWeatherBaseData());
                    mHoursForecastAdapter.setData(mWeatherModel.getHoursDatas());
                }else {
                    if(SystemClock.currentThreadTimeMillis() - mStartRefresh > MIN_REFRESH_MILLS) {
                        onWeatherUpdate(StatusDataResource.Status.SUCCESS.equals(status));
                    }else {
                        TaskScheduler.runOnUIThread(new Runnable() {
                            @Override
                            public void run() {
                                onWeatherUpdate(StatusDataResource.Status.SUCCESS.equals(status));
                            }
                        },MIN_REFRESH_MILLS+SystemClock.currentThreadTimeMillis() - mStartRefresh);
                    }
                }
            }

        });

        mWeatherModel.updateWeather();

    }

