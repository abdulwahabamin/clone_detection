    public static WeatherForecastDbHelper.WeatherForecastRecord updateWeatherForecast(
            Context context,
            long locationId,
            int fontColorId,
            Integer widgetId,
            RemoteViews remoteViews,
            Integer forecast_1_widget_day_layout,
            int forecast_1_widget_icon,
            int forecast_1_widget_day,
            int forecast_1_widget_temperatures,
            Integer forecast_2_widget_day_layout,
            int forecast_2_widget_icon,
            int forecast_2_widget_day,
            int forecast_2_widget_temperatures,
            Integer forecast_3_widget_day_layout,
            int forecast_3_widget_icon,
            int forecast_3_widget_day,
            int forecast_3_widget_temperatures,
            Integer forecast_4_widget_day_layout,
            int forecast_4_widget_icon,
            int forecast_4_widget_day,
            int forecast_4_widget_temperatures,
            Integer forecast_5_widget_day_layout,
            int forecast_5_widget_icon,
            int forecast_5_widget_day,
            int forecast_5_widget_temperatures) {
        final WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(context);
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        Location location = locationsDbHelper.getLocationById(locationId);
        if (location == null) {
            return null;
        }
        SimpleDateFormat sdfDayOfWeek = getDaysFormatter(context, widgetId, location.getLocale());

        Long daysCount = 5l;
        Boolean hoursForecast = null;
        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        if (widgetId != null) {
            daysCount = widgetSettingsDbHelper.getParamLong(widgetId, "forecastDaysCount");
            hoursForecast = widgetSettingsDbHelper.getParamBoolean(widgetId, "hoursForecast");
            if (daysCount == null) {
                daysCount = 5l;
            }
        }

        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(locationId);
        //appendLog(context, TAG, "updateWeatherForecast:locationId=" + locationId + ", weatherForecastRecord=" + weatherForecastRecord);
        if (weatherForecastRecord == null) {
            return null;
        }
        if ((hoursForecast != null) && hoursForecast) {
            return createForecastByHours(
                    context,
                    location,
                    fontColorId,
                    weatherForecastRecord,
                    daysCount,
                    remoteViews,
                    forecast_1_widget_day_layout,
                    forecast_1_widget_icon,
                    forecast_1_widget_day,
                    forecast_1_widget_temperatures,
                    forecast_2_widget_day_layout,
                    forecast_2_widget_icon,
                    forecast_2_widget_day,
                    forecast_2_widget_temperatures,
                    forecast_3_widget_day_layout,
                    forecast_3_widget_icon,
                    forecast_3_widget_day,
                    forecast_3_widget_temperatures,
                    forecast_4_widget_day_layout,
                    forecast_4_widget_icon,
                    forecast_4_widget_day,
                    forecast_4_widget_temperatures,
                    forecast_5_widget_day_layout,
                    forecast_5_widget_icon,
                    forecast_5_widget_day,
                    forecast_5_widget_temperatures
            );
        } else {
            return createForecastByDays(
                    context,
                    fontColorId,
                    weatherForecastRecord,
                    sdfDayOfWeek,
                    daysCount,
                    remoteViews,
                    forecast_1_widget_day_layout,
                    forecast_1_widget_icon,
                    forecast_1_widget_day,
                    forecast_1_widget_temperatures,
                    forecast_2_widget_day_layout,
                    forecast_2_widget_icon,
                    forecast_2_widget_day,
                    forecast_2_widget_temperatures,
                    forecast_3_widget_day_layout,
                    forecast_3_widget_icon,
                    forecast_3_widget_day,
                    forecast_3_widget_temperatures,
                    forecast_4_widget_day_layout,
                    forecast_4_widget_icon,
                    forecast_4_widget_day,
                    forecast_4_widget_temperatures,
                    forecast_5_widget_day_layout,
                    forecast_5_widget_icon,
                    forecast_5_widget_day,
                    forecast_5_widget_temperatures);
        }
    }

