    /**
     * Converts the JSON string (passed as an argument) to the correct weather information object,
     * and extracts the data required to instantiate nested fragments.
     */
    private void extractJsonDataForChildFragments() {
        String jsonString = getArguments().getString(WEATHER_INFO_JSON_STRING);
        Gson gson = new Gson();

        if (weatherInfoType == WeatherInfoType.DAILY_WEATHER_FORECAST) {
            extractDailyForecastJsonData(jsonString, gson);
        } else if (weatherInfoType == WeatherInfoType.THREE_HOURLY_WEATHER_FORECAST) {
            extractThreeHourlyForecastJsonData(jsonString, gson);
            if (jsonStringsForChildFragments.size() == 0) {
                return;
            }
            if (SharedPrefsHelper.getForecastDisplayMode(getContext()) ==
                    ThreeHourlyForecastDisplayMode.LIST) {
                splitThreeHourlyForecastsIntoDailyLists();
            }
        } else {
            throw new WeatherInfoType.IllegalWeatherInfoTypeArgumentException(weatherInfoType);
        }
    }

