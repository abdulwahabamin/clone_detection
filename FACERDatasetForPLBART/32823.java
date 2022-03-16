    public static Notification getNotification(Context context, Location location, CurrentWeatherDbHelper.WeatherRecord weatherRecord) {

        if (!AppPreference.isNotificationEnabled(context)) {
            return null;
        }

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        boolean isOutgoing = false;
        String notificationPresence = AppPreference.getNotificationPresence(context);
        if ("permanent".equals(notificationPresence) || "on_lock_screen".equals(notificationPresence)) {
            isOutgoing = true;
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("yourLocalWeather");
            boolean createNotification = notificationChannel == null;
            if (!createNotification &&
                    ((notificationChannel.getImportance() == NotificationManager.IMPORTANCE_LOW) ||
                            (AppPreference.isVibrateEnabled(context) && (notificationChannel.getVibrationPattern() == null)))) {
                notificationManager.deleteNotificationChannel("yourLocalWeather");
                createNotification = true;
            }
            if (createNotification) {
                NotificationChannel channel = new NotificationChannel("yourLocalWeather",
                        context.getString(R.string.notification_channel_name),
                        NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription(context.getString(R.string.notification_channel_description));
                channel.setVibrationPattern(isVibrateEnabled(context));
                channel.enableVibration(AppPreference.isVibrateEnabled(context));
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                channel.setSound(null, null);
                notificationManager.createNotificationChannel(channel);
            }
        }

        String notificationIconStyle = AppPreference.getNotificationStatusIconStyle(context);
        int notificationIcon;
        switch (notificationIconStyle) {
            case "icon_temperature": notificationIcon = TemperatureUtil.getTemperatureStatusIcon(context, weatherRecord); break;
            case "one_invisible_point": notificationIcon = R.drawable.one_transparent_point; break;
            case "icon_sun":
            default: notificationIcon = R.drawable.small_icon;
        }

        Notification notification;
        String notificationVisualStyle = AppPreference.getNotificationVisualStyle(context);
        switch (notificationVisualStyle) {
            case "custom_with_forecast": notification = customNotification(context, location, notificationIcon, isOutgoing, weatherRecord); break;
            case "build_in":
            default:
                notification = regularNotification(context, location, notificationIcon, isOutgoing, weatherRecord); break;
        }
        return notification;
    }

