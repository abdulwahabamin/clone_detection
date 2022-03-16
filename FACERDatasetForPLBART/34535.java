    private void initWeather() {
        if (!isNetWorkAccess()) {
            return;
        }
        weatherAdaper.removeALl();
        weatherService.getAllMyCities(new Action1<List<MyCity>>() {
            @Override
            public void call(List<MyCity> cities) {
                gMyCities = cities;
                List<String> cityIds = new ArrayList<String>();
                for (MyCity city : cities) {
                    cityIds.add(city.cityId);
                }
                weatherService.pickWeathers(cityIds, new Action1<List<WeatherData>>() {
                    @Override
                    public void call(List<WeatherData> weatherDatas) {
                        for (WeatherData data : weatherDatas) {
                            weatherAdaper.addWeatherData(data);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });
            }
        });

    }

