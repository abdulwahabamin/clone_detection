    public static void stopNotification(Service service) {

        NotificationManager notificationManager = (NotificationManager) service.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(NOTICE_ID_TYPE_0);
        notificationManager.cancel(NOTICE_ID_TYPE_ALARM);
        service.stopForeground(true);
    }

