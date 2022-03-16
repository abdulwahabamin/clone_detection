    public static WeatherMaxMinForDay calculateWeatherMaxMinForDay(List<DetailedWeatherForecast> forecastListForDay) {
        double maxRain = Double.MIN_VALUE;
        double maxSnow = Double.MIN_VALUE;
        double maxTemp = -Double.MAX_VALUE;
        double minTemp = Double.MAX_VALUE;
        double maxWind = 0;
        Long maxRainTime = null;
        Long maxSnowTime = null;
        Long maxTempTime = null;
        Long minTempTime = null;
        Long maxWindTime = null;
        Integer dayOfYear = null;

        if (forecastListForDay.isEmpty()) {
            return null;
        }

        Map <Double, Integer> windDirectionCounter = new HashMap<>();
        for (DetailedWeatherForecast weatherForecastForDay : forecastListForDay) {
                //WeatherCondition weatherCondition = weatherForecastForDay.getFirstWeatherCondition();
                /*appendLog(context, TAG, "preLoadWeather:weatherIdForTheDay=" + weatherIdForTheDay +
                        ":weatherForecastForDay.getTemperature()=" + weatherForecastForDay.getTemperature());*/
            long currentWeatherForecastDateTime = weatherForecastForDay.getDateTime() * 1000;
            if (dayOfYear == null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(currentWeatherForecastDateTime);
                dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
            }
            double currentTemp = weatherForecastForDay.getTemperature();
            if (maxTemp < currentTemp) {
                maxTemp = currentTemp;
                maxTempTime = currentWeatherForecastDateTime;
            }
            if (minTemp > currentTemp) {
                minTemp = currentTemp;
                minTempTime = currentWeatherForecastDateTime;
            }
            if (maxWind < weatherForecastForDay.getWindSpeed()) {
                maxWind = weatherForecastForDay.getWindSpeed();
                maxWindTime = currentWeatherForecastDateTime;
            }
            if (!windDirectionCounter.containsKey(weatherForecastForDay.getWindDegree())) {
                windDirectionCounter.put(weatherForecastForDay.getWindDegree(), 0);
            }
            windDirectionCounter.put(weatherForecastForDay.getWindDegree(), 1 + windDirectionCounter.get(weatherForecastForDay.getWindDegree()));
            if (maxRain < weatherForecastForDay.getRain()) {
                maxRain = weatherForecastForDay.getRain();
                maxRainTime = currentWeatherForecastDateTime;
            }
            if (maxSnow < weatherForecastForDay.getSnow()) {
                maxSnow = weatherForecastForDay.getSnow();
                maxSnowTime = currentWeatherForecastDateTime;
            }
        }
        double resultWindDegree = 0;
        int windCounter = 0;
        for (double windDegree: windDirectionCounter.keySet()) {
            int windDegreeCount = windDirectionCounter.get(windDegree);
            if (windCounter < windDegreeCount) {
                windCounter = windDegreeCount;
                resultWindDegree = windDegree;
            }
        }
        return new WeatherMaxMinForDay(dayOfYear, maxTemp, maxTempTime, minTemp, minTempTime, maxWind, maxWindTime, maxRain, maxRainTime, maxSnow, maxSnowTime, resultWindDegree);
    }

