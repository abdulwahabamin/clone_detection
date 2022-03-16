    public static void setWidgetTheme(Context context, RemoteViews remoteViews, int widgetId) {
        appendLog(context, TAG, "setWidgetTheme:start");
        int textColorId = AppPreference.getTextColor(context);
        int backgroundColorId = AppPreference.getWidgetBackgroundColor(context);
        int windowHeaderBackgroundColorId = AppPreference.getWindowHeaderBackgroundColorId(context);

        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        Boolean showLocation = widgetSettingsDbHelper.getParamBoolean(widgetId, "showLocation");
        if (showLocation == null) {
            showLocation = false;
        }
        if (showLocation) {
            remoteViews.setViewVisibility(R.id.widget_weather_forecast_1x3_widget_city, View.VISIBLE);
        } else {
            remoteViews.setViewVisibility(R.id.widget_weather_forecast_1x3_widget_city, View.GONE);
        }
        remoteViews.setInt(R.id.widget_weather_forecast_1x3_widget_root, "setBackgroundColor", backgroundColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_1_widget_day, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_1_widget_temperatures, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_2_widget_day, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_2_widget_temperatures, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_3_widget_day, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_3_widget_temperatures, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_4_widget_day, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_4_widget_temperatures, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_5_widget_day, textColorId);
        remoteViews.setTextColor(R.id.widget_weather_forecast_1x3_forecast_5_widget_temperatures, textColorId);

        appendLog(context, TAG, "setWidgetTheme:end");
    }

