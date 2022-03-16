    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        AppWidgetProviderAlarm appWidgetProviderAlarm =
                new AppWidgetProviderAlarm(context, LessWidgetProvider.class);
        appWidgetProviderAlarm.cancelAlarm();
    }

