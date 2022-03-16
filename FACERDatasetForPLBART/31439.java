        @Override
        public void onNext(WeatherEntity weatherEntity) {
            // 更新主界�?�
            Intent intent = new Intent(CityWeatherActivity.WEATHER_UPDATE_ACTION);
            intent.putExtra(CityWeatherActivity.WeatherUpdateReceiver.WEATHER_ENTITY, weatherEntity);
            //LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
            sendBroadcast(intent, Constants.RECV_WEATHER_UPDATE);

            // 更新appwidget
            Intent intent1 = new Intent(WeatherAppWidget.UPDATE_WIDGET_ACTION);
            intent1.putExtra(WeatherAppWidget.WEATHER_ENTITY, weatherEntity);
            sendBroadcast(intent1, Constants.RECV_WEATHER_UPDATE);

            // 更新通知�?
            boolean shouldNotify = FileUtil.getBooleanFromPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_NOTIFY_WEATHER, Constants.DEFAULT_NOTIFY_WEATHER);
            if (shouldNotify) {
                Intent notifyIntent = new Intent(getApplicationContext(), WeatherNotificationService.class);
                notifyIntent.putExtra(WeatherNotificationService.WEATHER_ENTITY, weatherEntity);
                startService(notifyIntent);
            }
        }

