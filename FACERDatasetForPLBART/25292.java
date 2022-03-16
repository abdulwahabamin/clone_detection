    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void buildNotification(NotificationCompat.Action action) {
        NotificationCompat.MediaStyle style = new NotificationCompat.MediaStyle();
        style.setMediaSession(mSession.getSessionToken());

        Intent playerIntent = new Intent(getApplicationContext(), SwipePlayerActivity.class);
        playerIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                playerIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent = new Intent(getApplicationContext(), MediaPlayerService.class);
        intent.setAction(Constants.ACTION_STOP);
        PendingIntent deleteIntent = PendingIntent.getService(getApplicationContext(), 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        byte[] imageData = rhythmSong.getImageData();
        if (imageData != null) {
            builder.setLargeIcon(getAlbumArt(imageData));
        }

        builder.setContentTitle(rhythmSong.getTrackTitle())
                .setSmallIcon(R.drawable.ic_play_arrow_white_24dp)
                .setContentText(rhythmSong.getArtistTitle())
                .setDeleteIntent(deleteIntent)
                .setContentIntent(contentIntent)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setOngoing(false)
                .setStyle(style);

        builder.addAction(generateAction(R.drawable.ic_previous_arrow_white_24dp, Constants.ACTION_PREVIOUS));
        builder.addAction(action);
        builder.addAction(generateAction(R.drawable.ic_next_arrow_white_24dp, Constants.ACTION_NEXT));
        style.setShowActionsInCompactView(0, 1, 2);

        if(action.getTitle().equals(Constants.ACTION_PAUSE)){
            builder.setOngoing(true).setPriority(Notification.PRIORITY_HIGH);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

