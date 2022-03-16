    @WorkerThread
    public void updateWeather(String cityId,final StatusDataResource<WeatherData> statusDataResource) {


        if(StatusDataResource.Status.SUCCESS.equals(statusDataResource.status)) {
            try {
                WeatherData weatherData = statusDataResource.data;
                Weather weather = new Weather();
                weather.cityId = weatherData.getCityId();
                weather.weatherJson = JsonHelper.toJson(weatherData);

                mWeatherDatabase.weatherDao().saveWeather(weather);
            }catch (Exception e) {
                LogHelper.error(TAG,"updateWeather error %s",e);
            }
        } else if(StatusDataResource.Status.LOADING.equals(statusDataResource.status)) {
            try {
                WeatherData weatherData = JsonHelper.fromJson(mWeatherDatabase.weatherDao().fetchWeather(cityId).weatherJson, WeatherData.class);
                if (weatherData != null) {
                    statusDataResource.data = weatherData;
                }
            }catch (Exception e) {
                LogHelper.error(TAG,"no cache hit");
            }

        }

        mWeatherDataLiveData.postValue(statusDataResource);
        Router.instance().getReceiver(EventCenter.NotificationStatus.class).onUpdateNotification();

    }

