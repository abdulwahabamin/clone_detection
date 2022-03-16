    private WeatherRepository() {
        mWeatherDatabase = DBHelper.provider(WeatherDatabase.class,WEATHER_DB_NAME);
        mWeatherWorkHandler = TaskScheduler.provideHandler(TAG);
        mWeatherDataLiveData = new MutableLiveData<>();

    }

