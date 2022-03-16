    @Override
    public void getWeatherDataFromCity(String cityName, final GetWeatherCallBack callBack) throws Exception {
        checkNotNull(cityName);
        Map<String, String> maps = new LinkedHashMap<>();
        maps.put("key", MyApplication.getHeweatherKey());
        maps.put("city", cityName);
        mCall = mApiService.getWeather(maps);
        NetService.getInstance().asynRequest(mCall, new IResponseListener<HWeather>() {
            @Override
            public void onSuccess(HWeather response) {
                callBack.onSuccess(response);
            }

            @Override
            public void onFailure(String message) {
                callBack.onFailure(message);
            }
        });
    }

