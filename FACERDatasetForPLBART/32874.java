    public static String getStrIcon(Context context, CurrentWeatherDbHelper.WeatherRecord weatherRecord) {
        if (weatherRecord == null) {
            return context.getString(R.string.icon_clear_sky_day);
        }
        return getStrIcon(context, weatherRecord.getWeather().getCurrentWeathers().iterator().next().getIdIcon());
    }

