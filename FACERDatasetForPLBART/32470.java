    private void checkNotification(Context context) {
        String notificationPresence = AppPreference.getNotificationPresence(context);
        if (!"on_lock_screen".equals(notificationPresence)) {
            return;
        }
        if (NotificationUtils.isScreenLocked(context)) {
            NotificationUtils.weatherNotification(context, getLocationForNotification().getId());
        } else {
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
        }
    }

