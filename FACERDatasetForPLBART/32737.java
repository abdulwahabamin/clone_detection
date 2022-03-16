    public static Set<WeatherForecastPerDay> calculateWeatherForDays(WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord) {
        Set<WeatherForecastPerDay> result = new HashSet<>();
        Calendar forecastCalendar = Calendar.getInstance();
        int initialYearForTheList = forecastCalendar.get(Calendar.YEAR);
        Map<Integer, List<DetailedWeatherForecast>> weatherList = createWeatherList(weatherForecastRecord);
        Integer firstDayOfYear = Collections.min(weatherList.keySet());
        int dayCounter = 0;
        int daysInList = firstDayOfYear + weatherList.keySet().size();
        for (int dayInYear = firstDayOfYear; dayInYear < daysInList; dayInYear++) {
            int dayInYearForList;
            int yearForList;
            if (dayInYear > 365) {
                dayInYearForList = dayInYear - 365;
                yearForList = initialYearForTheList + 1;
            } else {
                dayInYearForList = dayInYear;
                yearForList = initialYearForTheList;
            }
            if ((weatherList.get(dayInYear) == null) || (weatherList.get(dayInYear).size() < 3)) {
                continue;
            }
            dayCounter++;
            WeatherMaxMinForDay weatherMaxMinForDay = calculateWeatherMaxMinForDay(weatherList.get(dayInYear));
            if (weatherMaxMinForDay == null) {
                continue;
            }
            WeatherIdsForDay weatherIdsForTheDay = getWeatherIdForDay(weatherList.get(dayInYear), weatherMaxMinForDay);
            result.add(new WeatherForecastPerDay(dayCounter, weatherIdsForTheDay, weatherMaxMinForDay, getWeatherIconId(weatherIdsForTheDay.mainWeatherId, weatherList.get(dayInYear)), dayInYearForList, yearForList));
        }
        return result;
    }

