    public void displayPlayerNotification(Song currentSong, boolean isPlaying,
                                                  boolean ongoing) {
        this.currentSong = currentSong;

        NotificationCompat.Builder notificationBuilder = new Builder(context);

        //create custom views
        RemoteViews notificationView = new RemoteViews(context.getPackageName(),
                R.layout.notification_player);

        RemoteViews notificationExpandedView = new RemoteViews(context.getPackageName(),
                R.layout.notification_expanded_player);

        preparePlayerNotification(notificationView, isPlaying);
        prepareExpandedPlayerNotification(notificationExpandedView, isPlaying);

        notificationBuilder.setContent(notificationView);
        notificationBuilder.setCustomBigContentView(notificationExpandedView);

        notificationBuilder.setSmallIcon(R.drawable.glideplayer_notification);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);

        stackBuilder.addNextIntent(new Intent(context, MainActivity.class));
        stackBuilder.addNextIntent(new Intent(context, PlayerActivity.class));

        PendingIntent pendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);

        notificationBuilder.setOngoing(ongoing);

        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(playerNotificationId, notificationBuilder.build());
    }

