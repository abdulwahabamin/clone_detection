    public static String getLastUpdateTime(Context context,
                                           CurrentWeatherDbHelper.WeatherRecord weatherRecord,
                                           WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord,
                                           Location location) {
        Calendar lastUpdate = Calendar.getInstance();
        lastUpdate.setTimeInMillis(getLastUpdateTimeInMilis(weatherRecord, weatherForecastRecord, location));
        int lastUpdateDayOrYear = lastUpdate.get(Calendar.DAY_OF_YEAR);
        int lastUpdateYear = lastUpdate.get(Calendar.YEAR);
        Calendar today = Calendar.getInstance();
        int todayDayOrYear = today.get(Calendar.DAY_OF_YEAR);
        int todayYear = today.get(Calendar.YEAR);
        if ((lastUpdateDayOrYear == todayDayOrYear) && (lastUpdateYear == todayYear)) {
            return AppPreference.getLocalizedTime(context, lastUpdate.getTime(), location.getLocale())
                    + " "
                    + getUpdateSource(context, (location != null) ? location.getLocationSource() : "");
        } else {
            return AppPreference.getLocalizedDateTime(context, lastUpdate.getTime(), (lastUpdateYear != todayYear),location.getLocale())
                    + " "
                    + getUpdateSource(context, (location != null) ? location.getLocationSource() : "");
        }
    }

