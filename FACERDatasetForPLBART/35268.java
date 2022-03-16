    @Override
    public HWeather getWeatherDataFromCity(String cityName){
        checkNotNull(cityName);
        Map<String, String> maps = new LinkedHashMap<>();
        maps.put("key", MyApplication.getHeweatherKey());
        maps.put("city", cityName);
        mCall = mApiService.getWeather(maps);
        HWeather weather = NetService.getInstance().syncRequest(mCall);
        return weather;
    }

