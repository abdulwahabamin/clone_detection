    @Override
    public void queryWeather(final String cityId) {
        if(cityId == null || cityId.equals(mStringAtomicReference.get())) {
            return;
        }

        mStringAtomicReference.set(cityId);

        WeatherRepository.getInstance().getWeatherWorkHandler().post(new Runnable() {
            @Override
            public void run() {
                try {

                    WeatherRepository.getInstance().updateWeather(cityId,StatusDataResource.<WeatherData>loading());

                    CoreManager.getImpl(ICityProvider.class).saveCurrentCityId(cityId);

                    Call<HeWeather> weatherEntityCall  = mNetWeatherApi.getWeather(NetWeatherApi.sHeyWeatherKey,cityId);

                    /*
                    和风天气�?支�?县级空气质�?
                     */
                    City currentCity = CoreManager.getImpl(ICityProvider.class).searchCity(cityId);
                    String cityName = cityId;
                    if(currentCity !=null) {
                        cityName = currentCity.cityName;
                    }

                    Call<AqiEntity> aqiEntityCall  = mNetWeatherApi.getAqi(NetWeatherApi.sHeyWeatherKey,cityName);

                    Response<HeWeather> heWeatherResponse = weatherEntityCall.execute();
                    Response<AqiEntity> aqiEntityResponse = aqiEntityCall.execute();
                    if(heWeatherResponse.isSuccessful()) {
                        WeatherData weatherData = WeatherTransverter.convertFromHeWeather(heWeatherResponse.body(),aqiEntityResponse.body());
                        WeatherRepository.getInstance().updateWeather(cityId,StatusDataResource.success(weatherData));
                    }else {
                        LogHelper.error(TAG, "fetchWeather fail,response is %s",heWeatherResponse.errorBody());
                        WeatherRepository.getInstance().updateWeather(cityId,StatusDataResource.<WeatherData>error(heWeatherResponse.errorBody().string()));
                    }
                } catch (Exception e) {

                    LogHelper.error(TAG, "fetchWeather fail , error " +e);
                    WeatherRepository.getInstance().updateWeather(cityId,StatusDataResource.<WeatherData>error("更新失败"));
                }

                mStringAtomicReference.set($);

            }

        });
    }

