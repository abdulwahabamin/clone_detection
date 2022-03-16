    public static int getTemperatureStatusIcon(Context context, CurrentWeatherDbHelper.WeatherRecord weatherRecord) {
        if ((weatherRecord == null) || (weatherRecord.getWeather() == null)) {
            return R.drawable.zero0;
        }
        float temperature = (float) getTemperature(context, weatherRecord.getWeather());
        return getResourceForNumber(context, temperature);
    }

