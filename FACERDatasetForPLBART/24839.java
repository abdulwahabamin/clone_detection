    private Notification buildICSNotification() {

        MediaItem mSongData=PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER);

        mNotificationBuilder = new NotificationCompat.Builder(mContext);
        mNotificationBuilder.setOngoing(true);
        mNotificationBuilder.setAutoCancel(false);
        mNotificationBuilder.setSmallIcon(R.drawable.ic_music);

        //Open up the player screen when the user taps on the notification.
        Intent launchNowPlayingIntent = new Intent();
        launchNowPlayingIntent.setAction(SongPlayback.NOTIFY_LaunchNowPlaying);
        PendingIntent launchNowPlayingPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, launchNowPlayingIntent, 0);
        mNotificationBuilder.setContentIntent(launchNowPlayingPendingIntent);

        //Grab the notification layout.
        RemoteViews notificationView = new RemoteViews(mContext.getPackageName(), R.layout.custom_notification);

        //Initialize the notification layout buttons.
        Intent previousTrackIntent = new Intent();
        previousTrackIntent.setAction(SongPlayback.NOTIFY_PREVIOUS);
        PendingIntent previousTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, previousTrackIntent, 0);

        Intent playTrackIntent = new Intent();
        playTrackIntent.setAction(SongPlayback.NOTIFY_PLAY);
        PendingIntent playTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, playTrackIntent, 0);

        Intent pauseTrackIntent = new Intent();
        pauseTrackIntent.setAction(SongPlayback.NOTIFY_PLAY);
        PendingIntent pauseTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, pauseTrackIntent, 0);

        Intent nextTrackIntent = new Intent();
        nextTrackIntent.setAction(SongPlayback.NOTIFY_NEXT);
        PendingIntent nextTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, nextTrackIntent, 0);

        Intent stopServiceIntent = new Intent();
        stopServiceIntent.setAction(SongPlayback.NOTIFY_Close);
        PendingIntent stopServicePendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, stopServiceIntent, 0);

        notificationView.setOnClickPendingIntent(R.id.play, playTrackPendingIntent);
        notificationView.setOnClickPendingIntent(R.id.pause, pauseTrackPendingIntent);
        notificationView.setOnClickPendingIntent(R.id.next, nextTrackPendingIntent);
        notificationView.setOnClickPendingIntent(R.id.previous, previousTrackPendingIntent);
        notificationView.setOnClickPendingIntent(R.id.close, stopServicePendingIntent);

        //Check if audio is playing and set the appropriate play/pause button.
        if (isPlay) {
            notificationView.setViewVisibility(R.id.play, View.GONE);
            notificationView.setViewVisibility(R.id.pause, View.VISIBLE);
        } else {
            notificationView.setViewVisibility(R.id.play, View.VISIBLE);
            notificationView.setViewVisibility(R.id.pause, View.GONE);
        }

        notificationView.setTextViewText(R.id.songname, mSongData.getTitle());
        notificationView.setTextViewText(R.id.artist_album_name, mSongData.getArtist() + " | " + mSongData.getAlbum());


        //Set the "Stop Service" pending intent.
        notificationView.setOnClickPendingIntent(R.id.close, stopServicePendingIntent);

        //Set the album art.
        notificationView.setImageViewBitmap(R.id.album_art, getAlbumArtBitmap(mSongData.getAlbumArtPath()));

        //Attach the shrunken layout to the notification.
        mNotificationBuilder.setContent(notificationView);

        //Build the notification object and set its flags.
        Notification notification = mNotificationBuilder.build();
        notification.flags = Notification.FLAG_FOREGROUND_SERVICE |
                Notification.FLAG_NO_CLEAR |
                Notification.FLAG_ONGOING_EVENT;

        return notification;
    }

