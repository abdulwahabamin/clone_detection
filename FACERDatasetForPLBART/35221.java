    public WeatherLocalDataSource() {
        mProvinceDao = MyApplication.getDaoSession().getProvinceEntityDao();
        mCityDao = MyApplication.getDaoSession().getCityEntityDao();
        mLoveCityDao = MyApplication.getDaoSession().getLoveCityEntityDao();
        mWeatherDao = MyApplication.getDaoSession().getWeatherEntityDao();
    }

