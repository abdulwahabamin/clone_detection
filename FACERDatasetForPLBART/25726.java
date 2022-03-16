    @MainThread
    public void deleteWeather(final String cityId) {
        if(cityId == null) {
            return;
        }
        mWeatherWorkHandler.post(new Runnable() {
            @Override
            public void run() {
                mWeatherDatabase.weatherDao().deleteWeather(cityId);
            }
        });

    }

