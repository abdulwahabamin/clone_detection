    @Override
    public List<WeatherForecast> getWeatherForecasts() {

        List<WeatherForecast> weatherForecasts = new ArrayList<>();
        List<KnowWeather.DailyForecastEntity> dailyForecasts = knowWeather.getDailyForecast();
        for (KnowWeather.DailyForecastEntity dailyForecastEntity : dailyForecasts) {
            WeatherForecast weatherForecast = new WeatherForecast();
            weatherForecast.setCityId(knowWeather.getCityId());
            weatherForecast.setWind("");
            weatherForecast.setWeather(dailyForecastEntity.getWeather());
            weatherForecast.setWeek(dailyForecastEntity.getWeek());
            weatherForecast.setDate(dailyForecastEntity.getDate());
            int[] temperature = splitTemperature(dailyForecastEntity.getTemp_range());
            if (temperature != null) {
                weatherForecast.setTempMax(temperature[1]);
                weatherForecast.setTempMin(temperature[0]);
            }
            weatherForecasts.add(weatherForecast);
        }
        return weatherForecasts;
    }

