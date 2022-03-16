    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager,
                                          int appWidgetId, Bundle newOptions) {
        context.startService(new Intent(context, TodayWidgetIntentService.class));
        if (BuildConfig.DEBUG) Log.d(LOG_TAG,"onAppWidgetOptionsChanged()");
    }

