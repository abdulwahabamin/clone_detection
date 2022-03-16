    private static void setForecastDayInfo(
            Context context,
            ForecastUtil.WeatherForecastPerDay countedForecastForDay,
            int fontColorId,
            long daysCount,
            RemoteViews remoteViews,
            Integer dayViewId,
            int forecastIconId,
            int weatherIdForDayName,
            int weatherIdForTemperatures,
            SimpleDateFormat sdfDayOfWeek) {

        Calendar forecastCalendar = Calendar.getInstance();

        if (dayViewId != null) {
            if (countedForecastForDay.dayIndex > daysCount) {
                remoteViews.setViewVisibility(dayViewId, View.GONE);
                return;
            } else {
                remoteViews.setViewVisibility(dayViewId, View.VISIBLE);
            }
        }

        Utils.setForecastIcon(
                remoteViews,
                context,
                forecastIconId,
                countedForecastForDay.weatherIds.mainWeatherId,
                countedForecastForDay.iconId,
                countedForecastForDay.weatherMaxMinForDay.maxTemp,
                countedForecastForDay.weatherMaxMinForDay.maxWind,
                fontColorId);
        forecastCalendar.set(Calendar.DAY_OF_YEAR, countedForecastForDay.dayInYear);
        forecastCalendar.set(Calendar.YEAR, countedForecastForDay.year);
        remoteViews.setTextViewText(
                weatherIdForDayName,
                sdfDayOfWeek.format(forecastCalendar.getTime()));
        remoteViews.setTextViewText(
                weatherIdForTemperatures,
                Math.round(TemperatureUtil.getTemperatureInPreferredUnit(context, countedForecastForDay.weatherMaxMinForDay.minTemp)) +
                        "/" +
                        Math.round(TemperatureUtil.getTemperatureInPreferredUnit(context, countedForecastForDay.weatherMaxMinForDay.maxTemp)) +
                        TemperatureUtil.getTemperatureUnit(context));
    }

