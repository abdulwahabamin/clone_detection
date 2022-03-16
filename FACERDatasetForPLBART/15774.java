    public void displayNetworkNotification(String groupName, boolean isGroupOwner) {
        NotificationCompat.Builder notificationBuilder = new Builder(context);

        notificationBuilder.setContentTitle("GlidePlayer Network");
        if (groupName == null) {
            notificationBuilder.setContentText("Not connected to any group");
            notificationBuilder.setContentInfo("");
        } else {
            notificationBuilder.setContentText("Connected to " + groupName);
            if (isGroupOwner) {
                notificationBuilder.setContentInfo("(Owner)");
            } else {
                notificationBuilder.setContentInfo("");
            }
        }
        notificationBuilder.setWhen(0);

        notificationBuilder.setSmallIcon(R.mipmap.glideplayer_play_white);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_JUMP_TO_CONNECTIVITY_FRAGMENT, 0);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationBuilder.setOngoing(true);
        notificationBuilder.setPriority(PRIORITY_MIN);

        notificationManager.notify(networkNotificationId, notificationBuilder.build());
    }

