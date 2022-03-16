        @Override
        public void onReceive(Context context, Intent intent) {
            appendLog(context, TAG, "receive intent: ", intent);
            String notificationPresence = AppPreference.getNotificationPresence(context);
            if (AppPreference.isNotificationEnabled(context) &&
                    "on_lock_screen".equals(notificationPresence)) {
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancelAll();
            }
        }

