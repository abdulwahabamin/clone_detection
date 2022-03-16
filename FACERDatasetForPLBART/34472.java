    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        AppWidgetProviderAlarm appWidgetProviderAlarm =
                new AppWidgetProviderAlarm(context, MoreWidgetProvider.class);
        appWidgetProviderAlarm.cancelAlarm();
    }

