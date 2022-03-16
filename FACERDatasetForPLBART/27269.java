    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        super.onReceive(context, intent);
        if (WeatherService.ACTION_DATA_UPDATED.equals(intent.getAction())) {
            Intent updateIntent = new Intent(context, TodayWidgetIntentService.class);
            boolean sync = intent.getIntExtra(WeatherService.EXTRA_KEY_SYNC, 0) == 1;
            if (BuildConfig.DEBUG) Log.d(LOG_TAG,"onReceive ACTION_DATA_UPDATED sync="+sync);
            updateIntent.putExtra(WeatherService.EXTRA_KEY_SYNC, intent.getIntExtra(WeatherService.EXTRA_KEY_SYNC, 0));
            context.startService(updateIntent);
        }
        if (TodayWidgetIntentService.ACTION_APPWIDGET_REFRESH.equals(intent.getAction())){
            context.startService(new Intent(context, WeatherService.class));
            if (BuildConfig.DEBUG) Log.d(LOG_TAG,"onReceive ACTION_APPWIDGET_REFRESH start WeatherService");
        }
    }

