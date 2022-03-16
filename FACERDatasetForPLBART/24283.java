    /**
     * Link up various button actions using pending intents.
     * 
     * @param playerActive {@code true} if player is active in background
     */
    private void linkButtons(Context context, RemoteViews views, boolean playerActive) {
        Class<?> activityClass = playerActive && !context.getResources().getBoolean(R.bool.tablet_layout)
                ? MediaPlaybackActivity.class
                : MusicBrowserActivity.class;

        views.setOnClickPendingIntent(R.id.appwidget, PendingIntent.getActivity(context,
                0, new Intent(context, activityClass), 0));

        views.setOnClickPendingIntent(R.id.pause, PendingIntent.getService(context,
                0, new Intent(nu.staldal.djdplayer.MediaPlaybackService.TOGGLEPAUSE_ACTION).setClass(context, MobileMediaPlaybackService.class), 0));

        views.setOnClickPendingIntent(R.id.next, PendingIntent.getService(context,
                0, new Intent(nu.staldal.djdplayer.MediaPlaybackService.NEXT_ACTION).setClass(context, MobileMediaPlaybackService.class), 0));

        views.setOnClickPendingIntent(R.id.prev, PendingIntent.getService(context,
                0, new Intent(nu.staldal.djdplayer.MediaPlaybackService.PREVIOUS_ACTION).setClass(context, MobileMediaPlaybackService.class), 0));
    }

