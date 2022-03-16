    private static Notification customNotification(Context context,
                                                   Location location,
                                                   int notificationIcon,
                                                   boolean isOutgoing,
                                                   CurrentWeatherDbHelper.WeatherRecord weatherRecord) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_custom_weather);
        RemoteViews remoteViewsExpanded = new RemoteViews(context.getPackageName(), R.layout.notification_weather_forecast_expanded);

        Weather weather = weatherRecord.getWeather();

        String cityAndCountry = Utils.getCityAndCountry(context, location.getOrderId());
        String temperatureWithUnit = TemperatureUtil.getTemperatureWithUnit(
                context,
                weather,
                location.getLatitude(),
                weatherRecord.getLastUpdatedTime(),
                location.getLocale());
        remoteViews.setTextViewText(R.id.notification_custom_weather_widget_city, cityAndCountry);
        remoteViewsExpanded.setTextViewText(R.id.notification_weather_forecast_expanded_widget_city, cityAndCountry);
        remoteViews.setTextViewText(R.id.notification_custom_weather_widget_temperature, temperatureWithUnit);
        remoteViewsExpanded.setTextViewText(R.id.notification_weather_forecast_expanded_widget_temperature, temperatureWithUnit);
        String secondTemperature = TemperatureUtil.getSecondTemperatureWithUnit(
                context,
                weather,
                location.getLatitude(),
                weatherRecord.getLastUpdatedTime(),
                location.getLocale());
        if (secondTemperature != null) {
            remoteViews.setViewVisibility(R.id.notification_custom_weather_widget_second_temperature, View.VISIBLE);
            remoteViews.setTextViewText(R.id.notification_custom_weather_widget_second_temperature, secondTemperature);
            remoteViewsExpanded.setViewVisibility(R.id.notification_weather_forecast_expanded_widget_second_temperature, View.VISIBLE);
            remoteViewsExpanded.setTextViewText(R.id.notification_weather_forecast_expanded_widget_second_temperature, secondTemperature);
        } else {
            remoteViews.setViewVisibility(R.id.notification_custom_weather_widget_second_temperature, View.GONE);
            remoteViewsExpanded.setViewVisibility(R.id.notification_weather_forecast_expanded_widget_second_temperature, View.GONE);
        }
        String weatherDescription = Utils.getWeatherDescription(context,
                location.getLocaleAbbrev(),
                weather);
        remoteViews.setTextViewText(R.id.notification_custom_weather_widget_description, weatherDescription);
        remoteViewsExpanded.setTextViewText(R.id.notification_weather_forecast_expanded_widget_description, weatherDescription);

        int iconColorBlack = ContextCompat.getColor(context, R.color.widget_lightTheme_textColorPrimary);
        Utils.setWeatherIconWithColor(remoteViews, context, weatherRecord, R.id.notification_custom_weather_widget_icon, iconColorBlack);
        Utils.setWeatherIconWithColor(remoteViewsExpanded, context, weatherRecord, R.id.notification_weather_forecast_expanded_widget_icon, iconColorBlack);

        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = null;
        try {
            weatherForecastRecord = WidgetUtils.updateWeatherForecast(
                    context,
                    location.getId(),
                    iconColorBlack,
                    null,
                    remoteViewsExpanded,
                    null,
                    R.id.notification_weather_forecast_expanded_forecast_1_widget_icon,
                    R.id.notification_weather_forecast_expanded_forecast_1_widget_day,
                    R.id.notification_weather_forecast_expanded_forecast_1_widget_temperatures,
                    null,
                    R.id.notification_weather_forecast_expanded_forecast_2_widget_icon,
                    R.id.notification_weather_forecast_expanded_forecast_2_widget_day,
                    R.id.notification_weather_forecast_expanded_forecast_2_widget_temperatures,
                    null,
                    R.id.notification_weather_forecast_expanded_forecast_3_widget_icon,
                    R.id.notification_weather_forecast_expanded_forecast_3_widget_day,
                    R.id.notification_weather_forecast_expanded_forecast_3_widget_temperatures,
                    null,
                    R.id.notification_weather_forecast_expanded_forecast_4_widget_icon,
                    R.id.notification_weather_forecast_expanded_forecast_4_widget_day,
                    R.id.notification_weather_forecast_expanded_forecast_4_widget_temperatures,
                    null,
                    R.id.notification_weather_forecast_expanded_forecast_5_widget_icon,
                    R.id.notification_weather_forecast_expanded_forecast_5_widget_day,
                    R.id.notification_weather_forecast_expanded_forecast_5_widget_temperatures);
        } catch (Exception e) {
            appendLog(context, TAG, "preLoadWeather:error updating weather forecast", e);
        }
        String lastUpdate = Utils.getLastUpdateTime(context, weatherRecord, weatherForecastRecord, location);
        remoteViews.setTextViewText(R.id.notification_custom_weather_widget_last_update, lastUpdate);
        remoteViewsExpanded.setTextViewText(R.id.notification_weather_forecast_expanded_widget_last_update, lastUpdate);

        return new NotificationCompat.Builder(context, "yourLocalWeather")
                .setSmallIcon(notificationIcon)
                .setCustomContentView(remoteViews)
                .setCustomBigContentView(remoteViewsExpanded)
                .setVibrate(isVibrateEnabled(context))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setOngoing(isOutgoing)
                .setAutoCancel(true)
                .build();
    }

