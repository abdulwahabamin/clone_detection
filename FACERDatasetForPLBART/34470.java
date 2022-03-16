    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Constants.ACTION_FORCED_APPWIDGET_UPDATE:
                if(AppPreference.isUpdateLocationEnabled(context)) {
                    context.startService(new Intent(context, LocationUpdateService.class));
                } else {
                    context.startService(new Intent(context, MoreWidgetService.class));
                }
                break;
            case Intent.ACTION_LOCALE_CHANGED:
                context.startService(new Intent(context, MoreWidgetService.class));
                break;
            case Constants.ACTION_APPWIDGET_THEME_CHANGED:
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                ComponentName componentName = new ComponentName(context, MoreWidgetProvider.class);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(componentName);
                onUpdate(context, appWidgetManager, appWidgetIds);
                break;
            case Constants.ACTION_APPWIDGET_UPDATE_PERIOD_CHANGED:
                AppWidgetProviderAlarm widgetProviderAlarm =
                        new AppWidgetProviderAlarm(context, MoreWidgetProvider.class);
                if (widgetProviderAlarm.isAlarmOff()) {
                    break;
                } else {
                    widgetProviderAlarm.setAlarm();
                }
                break;
            default:
                super.onReceive(context, intent);
        }
    }

