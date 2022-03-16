    public static String getWeatherIconId(int weatherId, List<DetailedWeatherForecast> forecastListForDay) {
        for (DetailedWeatherForecast weatherForecastForDay : forecastListForDay) {
            WeatherCondition weatherCondition = weatherForecastForDay.getFirstWeatherCondition();
            if (weatherCondition.getWeatherId().equals(weatherId)) {
                return weatherCondition.getIcon();
            }
        }
        return null;
    }

