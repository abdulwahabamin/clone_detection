    private static void setForecastHourInfo(
            Context context,
            int fontColorId,
            int dayCounter,
            long daysCount,
            RemoteViews remoteViews,
            Integer dayViewId,
            int forecastIconId,
            int weatherIdForTheDay,
            int weatherIdForDayName,
            int weatherIdForTemperatures,
            String iconId,
            long forecastTime,
            double maxTemp,
            double minTemp,
            double maxWind,
            Location location) {

        if (dayViewId != null) {
            if (dayCounter > daysCount) {
                remoteViews.setViewVisibility(dayViewId, View.GONE);
                return;
            } else {
                remoteViews.setViewVisibility(dayViewId, View.VISIBLE);
            }
        }

        Calendar forecastCalendar = Calendar.getInstance();
        forecastCalendar.setTimeInMillis(forecastTime * 1000);
        Utils.setForecastIcon(
                remoteViews,
                context,
                forecastIconId,
                weatherIdForTheDay,
                iconId,
                maxTemp,
                maxWind,
                fontColorId);
        remoteViews.setTextViewText(
                weatherIdForDayName,
                AppPreference.getLocalizedHour(context, forecastCalendar.getTime(), location.getLocale()));
        remoteViews.setTextViewText(
                weatherIdForTemperatures,
                Math.round(TemperatureUtil.getTemperatureInPreferredUnit(context, minTemp)) +
                 "/" +
                 Math.round(TemperatureUtil.getTemperatureInPreferredUnit(context, maxTemp)) +
                 TemperatureUtil.getTemperatureUnit(context));
    }

