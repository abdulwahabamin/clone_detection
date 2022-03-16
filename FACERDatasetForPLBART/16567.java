    private Notification createNotification() {
        FireLog.d(TAG, "updateNotificationMetadata. metadata=" + metadata);
        if (metadata == null || playbackState == null) {
            return null;
        }

        MediaDescriptionCompat description = metadata.getDescription();

        Bitmap art = BitmapFactory.decodeResource(service.getResources(),
                R.drawable.ic_default_art);

        // Notification channels are only supported on Android O+.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }

        final NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(service, CHANNEL_ID);

        final int playPauseButtonPosition = addActions(notificationBuilder);
        notificationBuilder
                .setStyle(new MediaStyle()
                        // show only play/pause in compact view
                        .setShowActionsInCompactView(playPauseButtonPosition)
                        .setShowCancelButton(true)
                        .setCancelButtonIntent(stopIntent)
                        .setMediaSession(sessionToken))
                .setDeleteIntent(stopIntent)
                .setColor(notificationColor)
                .setSmallIcon(R.drawable.ic_notification)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setOnlyAlertOnce(true)
                .setContentIntent(createContentIntent(description))
                .setContentTitle(description.getTitle())
                .setContentText(description.getSubtitle())
                .setLargeIcon(art);

        setNotificationPlaybackState(notificationBuilder);

        // load album art async
        if (description.getIconUri() != null) {
            String artUrl = description.getIconUri().toString();
            fetchBitmapAsync(artUrl, notificationBuilder);
        }

        return notificationBuilder.build();
    }

