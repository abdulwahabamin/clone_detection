    @Override
    protected void preLoadWeather(Context context, RemoteViews remoteViews, int appWidgetId) {
        appendLog(context, TAG, "preLoadWeather:start");
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);

        Long locationId = widgetSettingsDbHelper.getParamLong(appWidgetId, "locationId");

        if (locationId == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
            if (!currentLocation.isEnabled()) {
                currentLocation = locationsDbHelper.getLocationByOrderId(1);
            }
        } else {
            currentLocation = locationsDbHelper.getLocationById(locationId);
        }

        if (currentLocation == null) {
            return;
        }

        WeatherForecastWidgetProvider.setWidgetTheme(context, remoteViews, appWidgetId);
        WeatherForecastWidgetProvider.setWidgetIntents(context, remoteViews, WeatherForecastWidgetProvider.class, appWidgetId);
        remoteViews.setTextViewText(R.id.widget_weather_forecast_1x3_widget_city, Utils.getCityAndCountry(context, currentLocation.getOrderId()));
        try {
            WidgetUtils.updateWeatherForecast(
                    context,
                    currentLocation.getId(),
                    appWidgetId,
                    remoteViews,
                    R.id.widget_weather_forecast_1x3_forecast_day_1,
                    R.id.widget_weather_forecast_1x3_forecast_1_widget_icon,
                    R.id.widget_weather_forecast_1x3_forecast_1_widget_day,
                    R.id.widget_weather_forecast_1x3_forecast_1_widget_temperatures,
                    R.id.widget_weather_forecast_1x3_forecast_day_2,
                    R.id.widget_weather_forecast_1x3_forecast_2_widget_icon,
                    R.id.widget_weather_forecast_1x3_forecast_2_widget_day,
                    R.id.widget_weather_forecast_1x3_forecast_2_widget_temperatures,
                    R.id.widget_weather_forecast_1x3_forecast_day_3,
                    R.id.widget_weather_forecast_1x3_forecast_3_widget_icon,
                    R.id.widget_weather_forecast_1x3_forecast_3_widget_day,
                    R.id.widget_weather_forecast_1x3_forecast_3_widget_temperatures,
                    R.id.widget_weather_forecast_1x3_forecast_day_4,
                    R.id.widget_weather_forecast_1x3_forecast_4_widget_icon,
                    R.id.widget_weather_forecast_1x3_forecast_4_widget_day,
                    R.id.widget_weather_forecast_1x3_forecast_4_widget_temperatures,
                    R.id.widget_weather_forecast_1x3_forecast_day_5,
                    R.id.widget_weather_forecast_1x3_forecast_5_widget_icon,
                    R.id.widget_weather_forecast_1x3_forecast_5_widget_day,
                    R.id.widget_weather_forecast_1x3_forecast_5_widget_temperatures);
        } catch (Exception e) {
            appendLog(context, TAG, "preLoadWeather:error updating weather forecast", e);
        }
        appendLog(context, TAG, "preLoadWeather:end");
    }

