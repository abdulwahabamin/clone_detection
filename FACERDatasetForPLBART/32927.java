    private static void updateWidgetForType(Context context, Class<?> widgetProvider) {
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);
        Intent intentToUpdate = new Intent(context, widgetProvider);
        ComponentName widgetComponent = new ComponentName(context, widgetProvider);
        int[] widgetIds = widgetManager.getAppWidgetIds(widgetComponent);
        intentToUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intentToUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, widgetIds);
        context.sendBroadcast(intentToUpdate);
    }

