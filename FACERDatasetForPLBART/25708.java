    @TargetApi(16)
    private static Notification generateCustomNotification(Context context) {

        NotificationCompat.Builder
                builder =  new NotificationCompat
                .Builder(context)
                .setContent(getNotificationContentView(context))
                .setPriority(NotificationCompat.PRIORITY_MAX).setOngoing(true);

        if (Version.buildVersion() >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setSmallIcon(R.mipmap.weather_small_icon);
        } else {
            builder.setSmallIcon(R.mipmap.core_icon);
        }


        Notification notification = builder.build();
        //wrap_content fit
        if (Version.buildVersion() >= Build.VERSION_CODES.JELLY_BEAN) {
            notification.bigContentView = getNotificationContentView(context);
        }

        generateAlarmNotification(context);

        return notification;
    }

