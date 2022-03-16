    public static void updateNotification(Service service) {

        WeatherData weatherData = WeatherRepository.getInstance().getCachedWeatherData();

        if(weatherData == null) {
            return;
        }


        boolean show = PreferencesHelper.get(ResourceProvider.NOTIFICATION_ALLOW, true);
        if (!show||service==null) {
            return;
        }
        try {
            Field mBase = ContextWrapper.class.getDeclaredField("mBase");
            mBase.setAccessible(true);
            Context context = (Context) mBase.get(service);
            if(context==null) {
                return;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        NotificationManager notificationManager = (NotificationManager) service.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = RemoteViewsHelper.generateCustomNotification(service);
        notificationManager.notify(NOTICE_ID_TYPE_0, notification);
    }

