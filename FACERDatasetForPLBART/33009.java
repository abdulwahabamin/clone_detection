    private static PendingIntent getActivityIntent(
            Context context,
            Class widgetClass,
            int widgetId,
            WidgetActions widgetAction) {
        Intent activityIntent = new Intent(context, widgetClass);
        Long widgetActionId = widgetAction.getId();
        activityIntent.setAction(Constants.ACTION_APPWIDGET_START_ACTIVITY + widgetActionId);
        activityIntent.putExtra("widgetId", widgetId);
        activityIntent.putExtra("widgetAction", widgetActionId);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
                activityIntent, 0);
        return pendingIntent;
    }

