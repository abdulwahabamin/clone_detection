    NotificationAction(Picasso picasso, Request data, RemoteViews remoteViews, int viewId,
        int notificationId, Notification notification, boolean skipCache, int errorResId,
        String key) {
      super(picasso, data, remoteViews, viewId, errorResId, skipCache, key);
      this.notificationId = notificationId;
      this.notification = notification;
    }

