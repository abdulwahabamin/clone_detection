    private Notification createNotification() {
        Log.d(TAG, "updateNotificationMetadata. mMetadata=" + mMetadata);
        if (mMetadata == null || mPlaybackState == null) {
            return null;
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(mService);

        // If skip to previous action is enabled
        if ((mPlaybackState.getActions() & PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS) != 0) {
            notificationBuilder.addAction(R.drawable.ic_skip_previous_grey_24dp,
                    "previous", mPreviousIntent);
        }

        addPlayPauseAction(notificationBuilder);

        // If add to playlist action is enabled
        if ((mPlaybackState.getActions() & PlaybackStateCompat.ACTION_SKIP_TO_NEXT) != 0) {
            notificationBuilder.addAction(R.drawable.ic_skip_next_grey_24dp,
                    "next", mNextIntent);
        }

        addAddToPlaylistAction(notificationBuilder);

        MediaDescriptionCompat description = mMetadata.getDescription();

        Bitmap art;
        int notificationColor;

        if (mMetadata.getDescription().getIconUri() != null) {
            art = BitmapFactory.decodeFile(mMetadata.getDescription().getIconUri().getEncodedPath());
        } else {
            art = BitmapFactory.decodeResource(mService.getResources(),
                    R.drawable.ic_audiotrack_grey_96dp);
        }

        notificationColor =
                ColorUtil
                        .getBackgroundColor(
                                ColorUtil.getColorSwatch(ColorUtil.generatePalette(art)));

        notificationBuilder
                .setColor(notificationColor)
                .setSmallIcon(R.drawable.ic_cassette_notification)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setUsesChronometer(true)
                .setContentIntent(createContentIntent(description))
                .setContentTitle(description.getTitle())
                .setContentText(description.getSubtitle())
                .setLargeIcon(art)
                .setDeleteIntent(mDeleteIntent)
                .setStyle(
                        new NotificationCompat
                                .MediaStyle()
                                .setShowActionsInCompactView(new int[]{0,1,2})
                .setMediaSession(mSessionToken));

        setNotificationPlaybackState(notificationBuilder);

        return notificationBuilder.build();
    }

