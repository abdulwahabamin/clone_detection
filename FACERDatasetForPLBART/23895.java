    private void setupForegroundNotification() {
        String NOTIFICATION_CHANNEL_ID = "org.fitchfamily.android.symphony";

        // Let the Music Controller know we are playing the song.
        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendInt = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setContentIntent(pendInt)
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if ((currentTrackPlayer != null) && (playingIndexInfo != null)) {
            Song songToPlay = songs.get(playingIndexInfo.getTrackIndex());    //get song info

            String trackTitle = songToPlay.getTitle();            //set title
            String trackAlbum = songToPlay.getAlbum();

            builder.setTicker(trackTitle)
                    .setContentTitle(songToPlay.getArtist())
                    .setContentText(trackTitle);
            if (trackTitle.compareTo(trackAlbum) != 0)
                builder.setSubText(trackAlbum);
        }
        Notification notify = builder.build();
        startForeground(NOTIFY_ID, notify);
    }

