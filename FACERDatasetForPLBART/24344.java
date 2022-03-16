    @Override
    protected void enrichNotification(NotificationCompat.Builder builder) {
        Class<?> activityClass = getResources().getBoolean(R.bool.tablet_layout)
                ? MusicBrowserActivity.class
                : MediaPlaybackActivity.class;

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, activityClass).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
                0);

        builder.setContentIntent(pendingIntent);
    }

