    /**
     * Update all active widget instances by pushing changes
     */
    public void performUpdate(ApolloService service, int[] appWidgetIds) {
        final RemoteViews views = new RemoteViews(service.getPackageName(),
                R.layout.onebyone_app_widget);

        // Set album art
        Bitmap bitmap = service.getAlbumBitmap();
        if (bitmap != null) {
            views.setViewVisibility(R.id.one_by_one_albumart, View.VISIBLE);
            views.setImageViewBitmap(R.id.one_by_one_albumart, bitmap);
        } else {
            views.setViewVisibility(R.id.one_by_one_albumart, View.INVISIBLE);
        }
        // Set correct contentDescription
        final boolean playing = service.isPlaying();
        if (playing) {
            views.setContentDescription(R.id.one_by_one_albumart,
                service.getResources().getString(R.string.nowplaying));
        } else {
            views.setContentDescription(R.id.one_by_one_albumart,
                service.getResources().getString(R.string.app_name));
        }

        // Link actions buttons to intents
        linkButtons(service, views, playing);

        pushUpdate(service, appWidgetIds, views);
    }

