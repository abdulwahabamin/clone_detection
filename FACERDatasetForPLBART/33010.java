    private static void setSettingButtonAction(Context context, int widgetId, String settingName, int buttonId, RemoteViews remoteViews, Class widgetClass) {
        Intent intentWeatherForecastWidgetProvider = new Intent(context, widgetClass);
        intentWeatherForecastWidgetProvider.setAction(Constants.ACTION_APPWIDGET_SETTINGS_OPENED + "__" + widgetId + "__" + settingName);
        intentWeatherForecastWidgetProvider.setPackage("org.thosp.yourlocalweather");
        PendingIntent pendingWeatherForecastWidgetProvider = PendingIntent.getBroadcast(context, 0,
                intentWeatherForecastWidgetProvider, 0);
        remoteViews.setOnClickPendingIntent(buttonId, pendingWeatherForecastWidgetProvider);
    }

