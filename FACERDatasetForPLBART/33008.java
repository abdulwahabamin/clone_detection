    private static PendingIntent getSwitchLocationIntent(Context context, Class widgetClass, int widgetId) {
        Intent intentSwitchLocality = new Intent(context, widgetClass);
        intentSwitchLocality.setAction(Constants.ACTION_APPWIDGET_CHANGE_LOCATION + "_" + widgetId);
        intentSwitchLocality.putExtra("widgetId", widgetId);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
                intentSwitchLocality, 0);
        return pendingIntent;
    }

