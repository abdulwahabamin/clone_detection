    public void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notifChannel = new NotificationChannel(getString(R.string.IONotifChannel), "IO Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notifChannel.setDescription("Receive notifications when moving files.");
            if (notifManager != null) {
                notifManager.createNotificationChannel(notifChannel);
            }
        }
    }

