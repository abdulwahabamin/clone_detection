    public static void showNotification(Service service) {

        WeatherData weatherData = WeatherRepository.getInstance().getCachedWeatherData();

        if(weatherData == null) {
            return;
        }


        boolean show = PreferencesHelper.get(ResourceProvider.NOTIFICATION_ALLOW, true);
        if (!show) {
            return;
        }

        Notification notification = RemoteViewsHelper.generateCustomNotification(service);
        service.startForeground(NOTICE_ID_TYPE_0, notification);// 开始�?�?��?务
    }

