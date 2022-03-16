    private static RemoteViews getNotificationContentView(Context context) {



        int themeId = ResourceProvider.getNotificationThemeId(PreferencesHelper.get(ResourceProvider.NOTIFICATION_THEME, 1));

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), themeId);

        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.notification_container, contentIntent);

        WeatherData weatherData = WeatherRepository.getInstance().getCachedWeatherData();

        if(weatherData == null) {
            return remoteViews;
        }


        WeatherData.BasicEntity basic = weatherData.getBasic();
        remoteViews.setTextViewText(R.id.weather_temp, basic.getTemp());
        remoteViews.setTextViewText(R.id.weather_status, basic.getWeather());
        remoteViews.setTextViewText(R.id.city, basic.getCity());
        remoteViews.setTextViewText(R.id.post_time, TimeUtil.getHourMinute() + " 更新");
        remoteViews.setImageViewResource(R.id.weather_icon, ResourceProvider.getIconId(basic.getWeather()));


        Intent updateIntent = new Intent(WeatherWidgetProvider.UPDATE_ACTION);
        context.sendBroadcast(updateIntent);

        return remoteViews;
    }

