    private void parseWeather(WeatherData weatherData) {

        mWeatherBaseData= weatherData.getBasic();

        List<HoursForecastData> hoursForecastDatas = new ArrayList<>();
        for (WeatherData.HoursForecastEntity hoursForecastEntity : weatherData.getHoursForecast()) {
            hoursForecastDatas.add(new HoursForecastData(hoursForecastEntity));
        }
        mHoursDatas = hoursForecastDatas ;

        mAqiData = new AqiData(weatherData.getAqi());

        List<DailyWeatherData> dailyWeatherDatas = new ArrayList<>();
        List<WeatherData.DailyForecastEntity> dailyForecastEntities = weatherData.getDailyForecast();
        for (int count = 0; count < dailyForecastEntities.size() - 2; count++) {
            // only take 5 days weather
            dailyWeatherDatas.add(new DailyWeatherData(dailyForecastEntities.get(count)));
        }
        mDailyData = dailyWeatherDatas;

        mLifeIndexData = new LifeIndexData(weatherData.getLifeIndex());
    }

