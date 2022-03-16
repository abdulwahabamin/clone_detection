    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        AppWidgetProviderAlarm appWidgetProviderAlarm =
                new AppWidgetProviderAlarm(context, MoreWidgetProvider.class);
        appWidgetProviderAlarm.setAlarm();
    }

