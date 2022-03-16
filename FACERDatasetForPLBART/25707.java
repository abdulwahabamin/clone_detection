    @TargetApi(16)
    private static void generateAlarmNotification(Context context) {

        if (!(PreferencesHelper.get(ResourceProvider.ALARM_ALLOW, true) && PreferencesHelper.get(ResourceProvider.NOTIFICATION_ALLOW, true))) {
            return;
        }
        WeatherData weatherData = WeatherRepository.getInstance().getCachedWeatherData();

        if (weatherData == null || weatherData.getAlarms() == null || weatherData.getAlarms().size() == 0) {
            return;
        }

        WeatherData.AlarmsEntity alarmsEntity = weatherData.getAlarms().get(0);

        Notification notification = new NotificationCompat.Builder(context).setOngoing(false).setPriority(NotificationCompat.PRIORITY_MAX).setContentTitle(alarmsEntity.getAlarmTypeDesc()).setContentText(alarmsEntity.getAlarmDesc()).setSmallIcon(R.mipmap.core_icon).build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTICE_ID_TYPE_ALARM, notification);

    }

