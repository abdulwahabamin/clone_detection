    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        AppWidgetProviderAlarm widgetProviderAlarm =
                new AppWidgetProviderAlarm(context, LessWidgetProvider.class);
        widgetProviderAlarm.setAlarm();
    }

