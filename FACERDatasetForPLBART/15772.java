    private void prepareExpandedPlayerNotification(RemoteViews notificationExpandedView,
                                                   boolean isPlaying) {
        //set drawables for expanded view
        String album_art = currentSong.getAlbumArt();

        if(album_art!=null && !album_art.equals("")) {
            notificationExpandedView.setImageViewUri(R.id.notification_expanded_album_art,
                    Uri.parse(album_art));
        } else {
            notificationExpandedView.setImageViewResource(R.id.notification_expanded_album_art,
                    R.mipmap.ic_album_white);
        }

        notificationExpandedView.setImageViewResource(R.id.notification_expanded_prev,
                R.mipmap.glideplayer_skip_prev_white);
        if(isPlaying) {
            notificationExpandedView.setImageViewResource(R.id.notification_expanded_play_pause,
                    R.mipmap.glideplayer_pause_white);
        } else {
            notificationExpandedView.setImageViewResource(R.id.notification_expanded_play_pause,
                    R.mipmap.glideplayer_play_white);
        }
        notificationExpandedView.setImageViewResource(R.id.notification_expanded_next,
                R.mipmap.glideplayer_skip_next_white);

        //set text
        notificationExpandedView.setTextViewText(R.id.notification_expanded_track_title,
                currentSong.getTitle());
        notificationExpandedView.setTextViewText(R.id.notification_expanded_track_artist,
                currentSong.getArtist());
        notificationExpandedView.setTextViewText(R.id.notification_expanded_track_album,
                currentSong.getAlbum());

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
        notificationExpandedView.setOnClickPendingIntent(R.id.notification_expanded_play_pause,
                pendingIntent);

        intent = new Intent(context, PlayerService.class);
        intent.putExtra(PlayerService.EXTRA_PLAY_CONTROL, PlayerService.PREV);
        pendingIntent = PendingIntent.getService(context, PREV_REQUEST_CODE, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notificationExpandedView.setOnClickPendingIntent(R.id.notification_expanded_prev,
                pendingIntent);

        intent = new Intent(context, PlayerService.class);
        intent.putExtra(PlayerService.EXTRA_PLAY_CONTROL, PlayerService.NEXT);
        pendingIntent = PendingIntent.getService(context, NEXT_REQUEST_CODE, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notificationExpandedView.setOnClickPendingIntent(R.id.notification_expanded_next,
                pendingIntent);
    }

