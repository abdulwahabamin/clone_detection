    @Override
    public void getCityWeather(String cityName) {
        try {
            mWeatherRepository.getWeatherDataFromCity(cityName, new WeatherDataSource.GetWeatherCallBack() {
                @Override
                public void onSuccess(HWeather weather) {
                    mWeatherRepository.saveWeather(weather);
                    mView.cancelRefresh();
                }

                @Override
                public void onFailure(String failureMessage) {

                }
            });
        } catch (Exception e) {
            mView.setNetWork();
            mView.cancelRefresh();

        }
    }

