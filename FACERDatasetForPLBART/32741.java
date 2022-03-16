    public static Map<Integer, List<DetailedWeatherForecast>> getOneDayForecast(WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord) {
        Map<Integer, List<DetailedWeatherForecast>> weatherList = createWeatherList(weatherForecastRecord);
        Integer firstDayInForecast = Collections.min(weatherList.keySet());
        List<DetailedWeatherForecast> wholeDayForecast = weatherList.get(firstDayInForecast);
        Map<Integer, List<DetailedWeatherForecast>> oneDayForecastMap = new HashMap<>();
        Calendar forecastCalendar = Calendar.getInstance();
        for (DetailedWeatherForecast detailedWeatherForecast: wholeDayForecast) {
            forecastCalendar.setTimeInMillis(detailedWeatherForecast.getDateTime() * 1000);
            int hourOfDay = forecastCalendar.get(Calendar.HOUR_OF_DAY);
            int dayPeriodIndex;
            if (hourOfDay < 6) {
                dayPeriodIndex = 0;
            } else if (hourOfDay <= 12) {
                dayPeriodIndex = 1;
            } else if (hourOfDay <= 19) {
                dayPeriodIndex = 2;
            } else {
                dayPeriodIndex = 3;
            }
            if (oneDayForecastMap.get(dayPeriodIndex) == null) {
                oneDayForecastMap.put(dayPeriodIndex, new ArrayList<DetailedWeatherForecast>());
            }
            oneDayForecastMap.get(dayPeriodIndex).add(detailedWeatherForecast);
        }
        return oneDayForecastMap;
    }

