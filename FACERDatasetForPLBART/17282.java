    private void setNotificationPlaybackState(NotificationCompat.Builder builder) {
        Log.d(TAG, "setNotificationPlaybackState. mPlaybackState=" + mPlaybackState);

        if (mPlaybackState == null) {
            Log.d(TAG, "setNotificationPlaybackState. cancelling notification!");
            return;
        }

        if (mPlaybackState.getState() == PlaybackStateCompat.STATE_PLAYING
                && mPlaybackState.getPosition() >= 0) {
            Log.d(TAG, "setNotificationPlaybackState. updating playback position to "+
                    (System.currentTimeMillis() - mPlaybackState.getPosition()) / 1000+ " seconds");
            builder
                    .setWhen(System.currentTimeMillis() - mPlaybackState.getPosition())
                    .setShowWhen(true)
                    .setUsesChronometer(true);
        } else {
            Log.d(TAG, "updateNotificationPlaybackState. hiding playback position");
            builder
                    .setWhen(0)
                    .setShowWhen(false)
                    .setUsesChronometer(false);
        }

        // Make sure that the notification can be dismissed by the user when we are not playing:
        builder.setOngoing(mPlaybackState.getState() == PlaybackStateCompat.STATE_PLAYING);

        Log.i(TAG, "setNotificationPlaybackState:"
                +(mPlaybackState.getState() == PlaybackStateCompat.STATE_PLAYING));
    }

