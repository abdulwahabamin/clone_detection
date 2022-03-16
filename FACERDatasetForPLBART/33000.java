    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        appendLog(context, TAG, "onUpdate:start");
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        ComponentName componentName = new ComponentName(context, getWidgetClass());
        int[] appWidgetIdsForWidget = appWidgetManager.getAppWidgetIds(componentName);

        for (int appWidgetId : appWidgetIds) {

            boolean found = false;
            for (int widgetIdToSearch: appWidgetIdsForWidget) {
                if (widgetIdToSearch == appWidgetId) {
                    found = true;
                }
            }
            if (!found) {
                continue;
            }

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    getWidgetLayout());

            if (ExtLocationWidgetProvider.class.equals(getWidgetClass())) {
                ExtLocationWidgetProvider.setWidgetTheme(context, remoteViews);
            } else if (MoreWidgetProvider.class.equals(getWidgetClass())) {
                MoreWidgetProvider.setWidgetTheme(context, remoteViews);
            } else if (LessWidgetProvider.class.equals(getWidgetClass())) {
                LessWidgetProvider.setWidgetTheme(context, remoteViews);
            } else if (ExtLocationWithForecastWidgetProvider.class.equals(getWidgetClass())) {
                ExtLocationWithForecastWidgetProvider.setWidgetTheme(context, remoteViews, appWidgetId);
            } else if (WeatherForecastWidgetProvider.class.equals(getWidgetClass())) {
                WeatherForecastWidgetProvider.setWidgetTheme(context, remoteViews, appWidgetId);
            } else if (ExtLocationWithGraphWidgetProvider.class.equals(getWidgetClass())) {
                ExtLocationWithGraphWidgetProvider.setWidgetTheme(context, remoteViews, appWidgetId);
            } else if (WeatherGraphWidgetProvider.class.equals(getWidgetClass())) {
                WeatherGraphWidgetProvider.setWidgetTheme(context, remoteViews, appWidgetId);
            } else if (ExtLocationWithForecastGraphWidgetProvider.class.equals(getWidgetClass())) {
                ExtLocationWithForecastGraphWidgetProvider.setWidgetTheme(context, remoteViews, appWidgetId);
            }
            setWidgetIntents(context, remoteViews, getWidgetClass(), appWidgetId);
            preLoadWeather(context, remoteViews, appWidgetId);

            try {
                appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
            } catch (Exception e) {
                appendLog(context, TAG, e.getMessage(), e);
            }
        }
        appendLog(context, TAG, "onUpdate:end");
    }

