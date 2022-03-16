    public static Map<Integer, List<DetailedWeatherForecast>> createWeatherList(WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord) {
        Map<Integer, List<DetailedWeatherForecast>> weatherList = new HashMap<>();
        Calendar forecastCalendar = Calendar.getInstance();
        int maxForecastDay = 0;
        for (DetailedWeatherForecast detailedWeatherForecast : weatherForecastRecord.getCompleteWeatherForecast().getWeatherForecastList()) {
            forecastCalendar.setTimeInMillis(detailedWeatherForecast.getDateTime() * 1000);
            int forecastDay = forecastCalendar.get(Calendar.DAY_OF_YEAR);
            if (maxForecastDay > forecastDay) {
                forecastDay += 365;
            }
            maxForecastDay = forecastDay;
            if (!weatherList.keySet().contains(forecastDay)) {
                List<DetailedWeatherForecast> dayForecastList = new ArrayList<>();
                weatherList.put(forecastDay, dayForecastList);
            }
            //appendLog(context, TAG, "preLoadWeather:forecastDay=" + forecastDay + ":detailedWeatherForecast=" + detailedWeatherForecast);
            weatherList.get(forecastDay).add(detailedWeatherForecast);
        }
        return weatherList;
    }

