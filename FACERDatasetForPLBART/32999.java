    private void performActionOnReceiveForWidget(Context context, Intent intent, int widgetId) {
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        Long locationId = widgetSettingsDbHelper.getParamLong(widgetId, "locationId");
        if (locationId == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
            if (!currentLocation.isEnabled()) {
                currentLocation = locationsDbHelper.getLocationByOrderId(1);
            }
        } else {
            currentLocation = locationsDbHelper.getLocationById(locationId);
        }
        switch (intent.getAction()) {
            case "org.thosp.yourlocalweather.action.WEATHER_UPDATE_RESULT":
            case "android.appwidget.action.APPWIDGET_UPDATE":
                if (!servicesStarted) {
                    onEnabled(context);
                    servicesStarted = true;
                }
                onUpdate(context, widgetManager, new int[] {widgetId});
                break;
            case Intent.ACTION_LOCALE_CHANGED:
            case Constants.ACTION_APPWIDGET_THEME_CHANGED:
            case Constants.ACTION_APPWIDGET_SETTINGS_SHOW_CONTROLS:
                refreshWidgetValues(context);
                break;
            case Constants.ACTION_APPWIDGET_UPDATE_PERIOD_CHANGED:
                onEnabled(context);
                break;
            case Constants.ACTION_APPWIDGET_CHANGE_SETTINGS:
                onUpdate(context, widgetManager, new int[]{ widgetId});
                break;
        }

        if (intent.getAction().startsWith(Constants.ACTION_APPWIDGET_SETTINGS_OPENED)) {
            String[] params = intent.getAction().split("__");
            String widgetIdTxt = params[1];
            widgetId = Integer.parseInt(widgetIdTxt);
            openWidgetSettings(context, widgetId, params[2]);
        } else if (intent.getAction().startsWith(Constants.ACTION_APPWIDGET_START_ACTIVITY)) {
            AppPreference.setCurrentLocationId(context, currentLocation);
            Long widgetActionId = intent.getLongExtra("widgetAction", 1);
            Class activityClass = WidgetActions.getById(widgetActionId, "action_current_weather_icon").getActivityClass();
            Intent activityIntent = new Intent(context, activityClass);
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(activityIntent);
        } else if (intent.getAction().startsWith(Constants.ACTION_APPWIDGET_CHANGE_LOCATION)) {
            changeLocation(widgetId, locationsDbHelper, widgetSettingsDbHelper);
            GraphUtils.invalidateGraph();
            onUpdate(context, widgetManager, new int[]{widgetId});
        } else if (intent.getAction().startsWith(Constants.ACTION_FORCED_APPWIDGET_UPDATE)) {
            if (!WidgetRefreshIconService.isRotationActive) {
                sendWeatherUpdate(context, widgetId);
            }
            onUpdate(context, widgetManager, new int[]{ widgetId});

        }
    }

