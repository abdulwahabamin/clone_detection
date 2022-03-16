    private int addActions(final NotificationCompat.Builder notificationBuilder) {
        FireLog.d(TAG, "addActions");

        int playPauseButtonPosition = 0;
        // If skip to previous action is enabled
        if ((playbackState.getActions() & PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS) != 0) {
            notificationBuilder.addAction(R.drawable.ic_media_previous_notification,
                    service.getString(R.string.label_previous), previousIntent);

            // If there is a "skip to previous" button, the play/pause button will
            // be the second one. We need to keep track of it, because the MediaStyle notification
            // requires to specify the index of the buttons (actions) that should be visible
            // when in compact view.
            playPauseButtonPosition = 1;
        }

        // Play or pause button, depending on the current state.
        final String label;
        final int icon;
        final PendingIntent intent;
        if (playbackState.getState() == PlaybackStateCompat.STATE_PLAYING) {
            label = service.getString(R.string.label_pause);
            icon = R.drawable.ic_media_pause_notification;
            intent = pauseIntent;
        } else {
            label = service.getString(R.string.label_play);
            icon = R.drawable.ic_media_play_notification;
            intent = playIntent;
        }
        notificationBuilder.addAction(new NotificationCompat.Action(icon, label, intent));

        // If skip to next action is enabled
        if ((playbackState.getActions() & PlaybackStateCompat.ACTION_SKIP_TO_NEXT) != 0) {
            notificationBuilder.addAction(R.drawable.ic_media_next_notification,
                    service.getString(R.string.label_next), nextIntent);
        }

        return playPauseButtonPosition;
    }

