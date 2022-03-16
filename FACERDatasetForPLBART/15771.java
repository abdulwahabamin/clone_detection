    private void preparePlayerNotification(RemoteViews notificationView, boolean isPlaying) {
        //set drawables for small view
        String album_art = currentSong.getAlbumArt();

        if(album_art!=null && !album_art.equals("")) {
            notificationView.setImageViewUri(R.id.notification_album_art,
                    Uri.parse(album_art));
        } else {
            notificationView.setImageViewResource(R.id.notification_album_art,
                    R.mipmap.ic_album_white);
        }

        notificationView.setImageViewResource(R.id.notification_prev,
                R.mipmap.glideplayer_skip_prev_white);

        if(isPlaying) {
            notificationView.setImageViewResource(R.id.notification_play_pause,
                    R.mipmap.glideplayer_pause_white);
        } else {
            notificationView.setImageViewResource(R.id.notification_play_pause,
                    R.mipmap.glideplayer_play_white);
        }
        notificationView.setImageViewResource(R.id.notification_next,
                R.mipmap.glideplayer_skip_next_white);

        //set text
        notificationView.setTextViewText(R.id.notification_track_title,
                currentSong.getTitle());
        notificationView.setTextViewText(R.id.notification_track_artist,
                currentSong.getArtist());

        //set click listeners
        Intent intent;
        PendingIntent pendingIntent;

        intent = new Intent(context, PlayerService.class);
        if(isPlaying) {
            intent.putExtra(PlayerService.EXTRA_PLAY_CONTROL, PlayerService.PAUSE);
            pendingIntent = PendingIntent.getService(context, PAUSE_REQUEST_CODE, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
        } else {
            intent.putExtra(PlayerService.EXTRA_PLAY_CONTROL, PlayerService.PLAY);
            pendingIntent = PendingIntent.getService(context, PLAY_REQUEST_CODE, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
        }
        notificationView.setOnClickPendingIntent(R.id.notification_play_pause, pendingIntent);

        intent = new Intent(context, PlayerService.class);
        intent.putExtra(PlayerService.EXTRA_PLAY_CONTROL, PlayerService.PREV);
        pendingIntent = PendingIntent.getService(context, PREV_REQUEST_CODE, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notificationView.setOnClickPendingIntent(R.id.notification_prev, pendingIntent);

        intent = new Intent(context, PlayerService.class);
        intent.putExtra(PlayerService.EXTRA_PLAY_CONTROL, PlayerService.NEXT);
        pendingIntent = PendingIntent.getService(context, NEXT_REQUEST_CODE, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notificationView.setOnClickPendingIntent(R.id.notification_next, pendingIntent);
    }

