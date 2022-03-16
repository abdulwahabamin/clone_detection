    @WorkerThread
    public List<WeatherData> getFollowedWeather() {
        List<WeatherData> followedWeather = new ArrayList<>();
        try {
            for(Weather weather:mWeatherDatabase.weatherDao().fetchFollowedWeather()) {
                WeatherData weatherData = JsonHelper.fromJson(weather.weatherJson,WeatherData.class);
                followedWeather.add(weatherData);
            }

        }catch (Exception e) {
            LogHelper.info(TAG,"getFollowedWeather error %s",e);
        }

        return followedWeather;
    }

