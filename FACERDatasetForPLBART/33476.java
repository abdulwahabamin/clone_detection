    /**
     * A constructor of SQLOperation, where the specified weather information type determines
     * which columns will be queried or updated.
     *
     * @param weatherInfoType a kind of weather information
     */
    public SqlOperation(Context context, WeatherInfoType weatherInfoType) {
        this.context = context;
        switch (weatherInfoType) {
            case CURRENT_WEATHER:
                columnNameForJsonString = CityTable.COLUMN_CACHED_JSON_CURRENT;
                columnNameForLastQueryTime = CityTable.COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER;
                break;
            case DAILY_WEATHER_FORECAST:
                columnNameForJsonString = CityTable.COLUMN_CACHED_JSON_DAILY_FORECAST;
                columnNameForLastQueryTime =
                        CityTable.COLUMN_LAST_QUERY_TIME_FOR_DAILY_WEATHER_FORECAST;
                break;
            case THREE_HOURLY_WEATHER_FORECAST:
                columnNameForJsonString = CityTable.COLUMN_CACHED_JSON_THREE_HOURLY_FORECAST;
                columnNameForLastQueryTime =
                        CityTable.COLUMN_LAST_QUERY_TIME_FOR_THREE_HOURLY_WEATHER_FORECAST;
                break;
            default:
                throw new WeatherInfoType.IllegalWeatherInfoTypeArgumentException(
                        weatherInfoType);
        }
    }

