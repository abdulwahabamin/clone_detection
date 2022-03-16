    public static boolean shouldUpdateForecast(Context context, long locationId) {
        WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(context);
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord =
                weatherForecastDbHelper.getWeatherForecast(locationId);
        long now = Calendar.getInstance().getTimeInMillis();
        if (weatherForecastRecord == null) {
            return true;
        }
        long firstForecastTime = 1000 * weatherForecastRecord.getCompleteWeatherForecast().getWeatherForecastList().get(0).getDateTime();
        if ((firstForecastTime < now) || (weatherForecastRecord.getLastUpdatedTime() +
                        AUTO_FORECAST_UPDATE_TIME_MILIS) <  now) {
            return true;
        }
        appendLogLastUpdateTime(context,
                TAG,
                "weatherForecastRecord.getLastUpdatedTime():",
                weatherForecastRecord,
                ", now:",
                now);
        return false;
    }

