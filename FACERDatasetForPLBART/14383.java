    private void updateNotification() {
        Bitmap b = getAlbumBitmap();
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.status_bar);
        RemoteViews bigViews = new RemoteViews(getPackageName(), R.layout.status_bar_expanded);
        
        if (b != null) {
            views.setViewVisibility(R.id.status_bar_icon, View.GONE);
            views.setViewVisibility(R.id.status_bar_album_art, View.VISIBLE);
            views.setImageViewBitmap(R.id.status_bar_album_art, b);
            bigViews.setImageViewBitmap(R.id.status_bar_album_art, b);
        } else {
            views.setViewVisibility(R.id.status_bar_icon, View.VISIBLE);
            views.setViewVisibility(R.id.status_bar_album_art, View.GONE);
        }
        
        ComponentName rec = new ComponentName(getPackageName(),
                MediaButtonIntentReceiver.class.getName());
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.putExtra(CMDNOTIF, 1);
        mediaButtonIntent.setComponent(rec);
        KeyEvent mediaKey = new KeyEvent(KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
        mediaButtonIntent.putExtra(Intent.EXTRA_KEY_EVENT, mediaKey);
        PendingIntent mediaPendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                1, mediaButtonIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.status_bar_play, mediaPendingIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_play, mediaPendingIntent);
        
        mediaButtonIntent.putExtra(CMDNOTIF, 2);
        mediaKey = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT);
        mediaButtonIntent.putExtra(Intent.EXTRA_KEY_EVENT, mediaKey);
        mediaPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 2,
                mediaButtonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        views.setOnClickPendingIntent(R.id.status_bar_next, mediaPendingIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_next, mediaPendingIntent);

        mediaButtonIntent.putExtra(CMDNOTIF, 4);
        mediaKey = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS);
        mediaButtonIntent.putExtra(Intent.EXTRA_KEY_EVENT, mediaKey);
        mediaPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 4,
                mediaButtonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        bigViews.setOnClickPendingIntent(R.id.status_bar_prev, mediaPendingIntent);
        
        mediaButtonIntent.putExtra(CMDNOTIF, 3);
        mediaKey = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_STOP);
        mediaButtonIntent.putExtra(Intent.EXTRA_KEY_EVENT, mediaKey);
        mediaPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 3,
                mediaButtonIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.status_bar_collapse, mediaPendingIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_collapse, mediaPendingIntent);
        
        views.setImageViewResource(R.id.status_bar_play, R.drawable.butter_holo_dark_pause);
        bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.butter_holo_dark_pause);

        views.setTextViewText(R.id.status_bar_track_name, getTrackName());
        bigViews.setTextViewText(R.id.status_bar_track_name, getTrackName());
        
        views.setTextViewText(R.id.status_bar_artist_name, getArtistName());
        bigViews.setTextViewText(R.id.status_bar_artist_name, getArtistName());
        
        bigViews.setTextViewText(R.id.status_bar_album_name, getAlbumName());
        
        status = new Notification.Builder(this).build();
        status.contentView = views;
        status.bigContentView = bigViews;
        status.flags = Notification.FLAG_ONGOING_EVENT;
        status.icon = R.drawable.stat_notify_music;
        status.contentIntent = PendingIntent
                .getActivity(this, 0, new Intent("com.spacecaker.butter.PLAYBACK_VIEWER")
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), 0);
        startForeground(PLAYBACKSERVICE_STATUS, status);
    }

