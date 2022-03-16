    private void setNotificationPlaybackState(NotificationCompat.Builder builder) {
        FireLog.d(TAG, "updateNotificationPlaybackState. playbackState=" + playbackState);
        if (playbackState == null || !mStarted) {
            FireLog.d(TAG, "updateNotificationPlaybackState. cancelling notification!");
            service.stopForeground(true);
            return;
        }

        // Make sure that the notification can be dismissed by the user when we are not playing:
        builder.setOngoing(playbackState.getState() == PlaybackStateCompat.STATE_PLAYING);
    }

