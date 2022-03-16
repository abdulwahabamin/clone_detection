    private Notification buildNotification() {
        String trackName;
        String artistName;
        if (getAudioId() < 0) { // streaming
            trackName = getString(R.string.streaming);
            artistName = null;
        } else {
            trackName = getTrackName();
            artistName = getArtistName();
            if (artistName == null || artistName.equals(MediaStore.UNKNOWN_STRING)) {
                artistName = getString(R.string.unknown_artist_name);
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.stat_notify_musicplayer);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon));
        builder.setContentTitle(trackName);
        builder.setContentText(artistName);
        builder.setOngoing(true);
        builder.setWhen(0);
        builder.addAction(android.R.drawable.ic_media_previous, getResources().getString(R.string.prev),
                getPendingIntentForAction(PREVIOUS_ACTION));
        builder.addAction(android.R.drawable.ic_media_pause, getResources().getString(R.string.pause),
                getPendingIntentForAction(PAUSE_ACTION));
        builder.addAction(android.R.drawable.ic_media_next, getResources().getString(R.string.next),
                getPendingIntentForAction(NEXT_ACTION));
        builder.setStyle(new NotificationCompat.MediaStyle().setShowActionsInCompactView(0, 1, 2));

        enrichNotification(builder);

        applyLillipopFunctionality(builder);

        return builder.build();
    }

