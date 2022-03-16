    public static void setWidgetIntents(Context context, RemoteViews remoteViews, Class<?>  widgetClass, int widgetId) {
        appendLog(context, TAG, "setWidgetIntents:widgetid:", widgetId);
        if (AppPreference.isShowControls(context)) {
            remoteViews.setViewVisibility(R.id.widget_weather_graph_1x3_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_graph_3x3_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_3x3_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_weather_forecast_1x3_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_3x3_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_less_3x1_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_more_3x3_settings_layout, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_graph_3x3_settings_layout, View.VISIBLE);
        } else {
            remoteViews.setViewVisibility(R.id.widget_weather_graph_1x3_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_graph_3x3_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_3x3_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_weather_forecast_1x3_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_3x3_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_less_3x1_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_more_3x3_settings_layout, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_ext_loc_forecast_graph_3x3_settings_layout, View.GONE);
        }

        Intent intentRefreshService = new Intent(context, widgetClass);
        intentRefreshService.setAction(Constants.ACTION_FORCED_APPWIDGET_UPDATE + "_" + widgetId);
        intentRefreshService.setPackage("org.thosp.yourlocalweather");
        intentRefreshService.putExtra("widgetId", widgetId);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
                intentRefreshService, 0);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_3x3_widget_button_refresh, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_3x3_widget_last_update, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_3x3_widget_button_refresh, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_3x3_widget_last_update, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_graph_3x3_widget_button_refresh, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_graph_3x3_widget_last_update, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_less_3x1_widget_button_refresh, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_less_3x1_widget_last_update, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_more_3x3_widget_button_refresh, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_more_3x3_widget_last_update, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_graph_3x3_widget_button_refresh, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_graph_3x3_widget_last_update, pendingIntent);

        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);

        WidgetActions mainIconAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_current_weather_icon"), "action_current_weather_icon");
        PendingIntent pendingIntentMainIconAction = getActionIntent(context, mainIconAction, widgetClass, widgetId);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_3x3_widget_icon, pendingIntentMainIconAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_3x3_widget_icon, pendingIntentMainIconAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_graph_3x3_widget_icon, pendingIntentMainIconAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_less_3x1_widget_icon, pendingIntentMainIconAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_more_3x3_widget_icon, pendingIntentMainIconAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_graph_3x3_widget_icon, pendingIntentMainIconAction);

        WidgetActions graphAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_graph"), "action_graph");
        PendingIntent pendingIntentGraphAction = getActionIntent(context, graphAction, widgetClass, widgetId);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_graph_3x3_forecast_graph, pendingIntentGraphAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_weather_graph_1x3_forecast_graph, pendingIntentGraphAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_graph_3x3_forecast_graph, pendingIntentGraphAction);

        WidgetActions forecastAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_forecast"), "action_forecast");
        PendingIntent pendingIntentForecastAction = getActionIntent(context, forecastAction, widgetClass, widgetId);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_3x3_forecast_layout, pendingIntentForecastAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_weather_forecast_1x3_forecast_layout, pendingIntentForecastAction);
        remoteViews.setOnClickPendingIntent(R.id.widget_ext_loc_forecast_graph_3x3_forecast_layout, pendingIntentForecastAction);

        Integer cityViewId = getCityViewId(widgetClass);
        if (cityViewId != null) {
            WidgetActions cityAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_city"), "action_city");
            PendingIntent pendingIntentCityAction = getActionIntent(context, cityAction, widgetClass, widgetId);
            remoteViews.setOnClickPendingIntent(getCityViewId(widgetClass), pendingIntentCityAction);
        }

        setSettingButtonAction(context, widgetId, "forecastSettings", R.id.widget_ext_loc_forecast_3x3_button_days_setting, remoteViews, ExtLocationWithForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "forecastSettings", R.id.widget_weather_forecast_1x3_button_days_setting, remoteViews, WeatherForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "forecastSettings", R.id.widget_ext_loc_forecast_graph_3x3_button_days_setting, remoteViews, ExtLocationWithForecastGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "graphSetting", R.id.widget_ext_loc_graph_3x3_button_graph_setting, remoteViews, ExtLocationWithGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "graphSetting", R.id.widget_weather_graph_1x3_button_graph_setting, remoteViews, WeatherGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "graphSetting", R.id.widget_ext_loc_forecast_graph_3x3_button_graph_setting, remoteViews, ExtLocationWithForecastGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "detailsSetting", R.id.widget_ext_loc_3x3_button_details_setting, remoteViews, ExtLocationWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "detailsSetting", R.id.widget_ext_loc_forecast_3x3_button_details_setting, remoteViews, ExtLocationWithForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "detailsSetting", R.id.widget_ext_loc_forecast_graph_3x3_button_details_setting, remoteViews, ExtLocationWithForecastGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "detailsSetting", R.id.widget_ext_loc_graph_3x3_button_details_setting, remoteViews, ExtLocationWithGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "detailsSetting", R.id.widget_more_3x3_button_details_setting, remoteViews, MoreWidgetProvider.class);

        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_ext_loc_forecast_3x3_button_location_setting, remoteViews, ExtLocationWithForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_weather_forecast_1x3_button_location_setting, remoteViews, WeatherForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_ext_loc_graph_3x3_button_location_setting, remoteViews, ExtLocationWithGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_weather_graph_1x3_button_location_setting, remoteViews, WeatherGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_weather_forecast_1x3_button_location_setting, remoteViews, WeatherForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_ext_loc_3x3_button_location_setting, remoteViews, ExtLocationWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_less_3x1_button_location_setting, remoteViews, LessWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_more_3x3_button_location_setting, remoteViews, MoreWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "locationSettings", R.id.widget_ext_loc_forecast_graph_3x3_button_location_setting, remoteViews, ExtLocationWithForecastGraphWidgetProvider.class);

        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_ext_loc_forecast_3x3_button_action_setting, remoteViews, ExtLocationWithForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_weather_forecast_1x3_button_action_setting, remoteViews, WeatherForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_ext_loc_graph_3x3_button_action_setting, remoteViews, ExtLocationWithGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_weather_graph_1x3_button_action_setting, remoteViews, WeatherGraphWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_weather_forecast_1x3_button_action_setting, remoteViews, WeatherForecastWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_ext_loc_3x3_button_action_setting, remoteViews, ExtLocationWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_less_3x1_button_action_setting, remoteViews, LessWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_more_3x3_button_action_setting, remoteViews, MoreWidgetProvider.class);
        setSettingButtonAction(context, widgetId, "widgetActionSettings", R.id.widget_ext_loc_forecast_graph_3x3_button_action_setting, remoteViews, ExtLocationWithForecastGraphWidgetProvider.class);
    }

