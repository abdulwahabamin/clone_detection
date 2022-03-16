    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.e("notificaiton","�?�动了");
        try {
            notificationWeather = mRepository.getLocalWeather(mRepository.getShowCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification();
        notification.icon = R.mipmap.icon;
        notification.tickerText = "天气状况查看";
        notification.when = System.currentTimeMillis();
        notification.flags = Notification.FLAG_NO_CLEAR;// �?能够自动清除
        notification.contentIntent = pendingIntent;

        RemoteViews contentViews = new RemoteViews(getPackageName(), R.layout.layout_notification);
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$id");
            Field field = clazz.getField("icon");
            field.setAccessible(true);
            int idIcon = field.getInt(null);
            contentViews.setImageViewResource(idIcon,R.mipmap.icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (notificationWeather != null) {
            contentViews.setTextViewText(R.id.city_text, WeatherJsonConverter.getWeather
                    (notificationWeather).getBasic().getCity());
            contentViews.setTextViewText(R.id.weather_text, WeatherJsonConverter.getWeather(notificationWeather).getNow().getCond().getTxt());
            contentViews.setImageViewResource(R.id.weather_image,
                    WeatherIcon.getWeatherImage(WeatherJsonConverter.getWeather(notificationWeather).getNow().getCond().getCode()));
            contentViews.setTextViewText(R.id.temperature_text, WeatherJsonConverter.getWeather(notificationWeather).getNow().getTmp()+"℃");
            String exerciseStr = "�?动情况:" + WeatherJsonConverter.getWeather(notificationWeather).getSuggestion().getSport().getBrf();
            contentViews.setTextViewText(R.id.exercise_text,exerciseStr);
            notification.contentView = contentViews;
            notificationManager.notify(NOTIFICATION_ID, notification);
            startForeground(NOTIFICATION_ID, notification);
        }
        return super.onStartCommand(intent, flags, startId);
    }

