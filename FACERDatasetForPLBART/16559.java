        @Override
        public void onMetadataChanged(MediaMetadataCompat metadata) {
            MediaNotificationManager.this.metadata = metadata;
            FireLog.d(TAG, "Received new metadata " + metadata);
            Notification notification = createNotification();
            if (notification != null) {
                notificationManager.notify(NOTIFICATION_ID, notification);
            }
        }

