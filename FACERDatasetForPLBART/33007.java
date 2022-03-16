    private static PendingIntent getActionIntent(Context context, WidgetActions widgetAction, Class widgetClass, int widgetId) {
        switch (widgetAction) {
            case LOCATION_SWITCH: return getSwitchLocationIntent(context, widgetClass, widgetId);
            case MAIN_SCREEN:
            case FORECAST_SCREEN:
            case GRAPHS_SCREEN:
            default:
                return getActivityIntent(context, widgetClass, widgetId, widgetAction);
        }
    }

