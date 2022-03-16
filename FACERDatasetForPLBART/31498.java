    @Override
    public void updateNotification(WeatherEntity entity) {
        // 更新appwidget
        Intent intent = new Intent(WeatherAppWidget.UPDATE_WIDGET_ACTION);
        intent.putExtra(WeatherAppWidget.WEATHER_ENTITY, entity);
        sendBroadcast(intent, Constants.RECV_WEATHER_UPDATE);

        // 更新通知�?
        boolean shouldNotify = FileUtil.getBooleanFromPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_NOTIFY_WEATHER, Constants.DEFAULT_NOTIFY_WEATHER);
        if (shouldNotify) {
            Intent notifyIntent = new Intent(getApplicationContext(), WeatherNotificationService.class);
            notifyIntent.putExtra(WeatherNotificationService.WEATHER_ENTITY, entity);
            startService(notifyIntent);
        }
    }

