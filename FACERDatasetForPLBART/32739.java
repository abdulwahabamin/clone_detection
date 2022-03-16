    public static WeatherIdsForDay getWeatherIdForDay(List<DetailedWeatherForecast> weatherListForDay,
                                                      WeatherMaxMinForDay weatherMaxMinForDay) {
        Map<Integer, String> weatherDescriptionsInDay = new HashMap<>();
        Map<Integer, Integer> weatherIdsInDay = new HashMap<>();
        for (DetailedWeatherForecast weatherForecastForDay : weatherListForDay) {
            WeatherCondition weatherCondition = weatherForecastForDay.getFirstWeatherCondition();
                /*appendLog(context, TAG, "preLoadWeather:dayInYear=" + dayInYearForList + ":dayCounter=" + dayCounter +
                        ":weatherCondition.getWeatherId()=" + weatherCondition.getWeatherId() +
                        ":weatherIdsInDay.get(weatherCondition.getWeatherId())=" + weatherIdsInDay.get(weatherCondition.getWeatherId()));*/
            if (weatherIdsInDay.get(weatherCondition.getWeatherId()) == null) {
                weatherIdsInDay.put(weatherCondition.getWeatherId(), 1);
            } else {
                weatherIdsInDay.put(weatherCondition.getWeatherId(), 1 + weatherIdsInDay.get(weatherCondition.getWeatherId()));
            }
            if (!weatherDescriptionsInDay.containsKey(weatherCondition.getWeatherId())) {
                weatherDescriptionsInDay.put(weatherCondition.getWeatherId(), weatherCondition.getDescription());
            }
        }
        Integer maxWeatherIdWithRain = 0;
        Integer maxWeatherIdWithSnow = 0;
        Integer weatherIdForTheDay = 0;
        int maxIconOccurrence = 0;
        for (Integer weatherId : weatherIdsInDay.keySet()) {
            int iconCount = weatherIdsInDay.get(weatherId);
            if (iconCount > maxIconOccurrence) {
                weatherIdForTheDay = weatherId;
                maxIconOccurrence = iconCount;
            }
            if (Utils.isWeatherDescriptionWithRain(weatherId) && (weatherId > maxWeatherIdWithRain)) {
                maxWeatherIdWithRain = weatherId;
            }
            if (Utils.isWeatherDescriptionWithSnow(weatherId) && (weatherId > maxWeatherIdWithSnow)) {
                maxWeatherIdWithSnow = weatherId;
            }
        }
        Integer warningWeatherId = null;
        if ((maxWeatherIdWithRain > 0) || (maxWeatherIdWithSnow > 0)) {
            double rainToConsider = (weatherMaxMinForDay.maxRain > 0.5) ? weatherMaxMinForDay.maxRain : 0;
            double snowToConsider = (weatherMaxMinForDay.maxSnow > 0.5) ? weatherMaxMinForDay.maxSnow : 0;
            if ((rainToConsider > 0) && (rainToConsider > snowToConsider)) {
                warningWeatherId = maxWeatherIdWithRain;
            } else if (snowToConsider > 0) {
                warningWeatherId = maxWeatherIdWithSnow;
            }
        }
        if (weatherIdForTheDay == warningWeatherId) {
            warningWeatherId = null;
        }
        return new WeatherIdsForDay(weatherIdForTheDay,
                warningWeatherId,
                weatherDescriptionsInDay.get(weatherIdForTheDay),
                (warningWeatherId != null) ? weatherDescriptionsInDay.get(warningWeatherId): null);
    }

