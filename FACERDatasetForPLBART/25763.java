    @Override
    public void updateItem(DailyWeatherData data, int position) {
        WeatherData.DailyForecastEntity dailyForecastData = data.dailyForecastData;
        if (Check.isNull(dailyForecastData)) {
            return;
        }

        if(dailyForecastData.getWeek().equals(TimeUtil.getWeek(TimeUtil.getMopnthDay()))) {
            dateWeek.setText("今天");
        }else {
            dateWeek.setText(dailyForecastData.getWeek());
        }

        weatherStatusDaily.setText(dailyForecastData.getWeather());
        tempDaily.setText(dailyForecastData.getTemp_range());
        weatherIconDaily.setImageResource(ResourceProvider.getIconId(dailyForecastData.getWeather()));
    }

