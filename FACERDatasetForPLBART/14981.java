    /**
     * Update all active widget instances by pushing changes
     */
    public void performUpdate(ApolloService service, int[] appWidgetIds) {

    	Context mContext = service.getApplicationContext();
    	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
    	String widget_type = sp.getString( WIDGET_STYLE, mContext.getResources().getString(R.string.widget_style_light) );

    	final RemoteViews views = new RemoteViews(mContext.getPackageName(),
                (widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.layout.fourbyone_app_widget:R.layout.fourbyone_app_widget_dark));
        

        CharSequence titleName = service.getTrackName();
        CharSequence artistName = service.getArtistName();

        views.setTextViewText(R.id.four_by_one_title, titleName);
        views.setTextViewText(R.id.four_by_one_artist, artistName);
        // Set album art
        Bitmap bitmap = service.getAlbumBitmap();
        if (bitmap != null) {
            views.setViewVisibility(R.id.four_by_one_albumart, View.VISIBLE);
            views.setViewVisibility(R.id.four_by_one_control_prev, View.GONE);
            views.setImageViewBitmap(R.id.four_by_one_albumart, bitmap);
        } else {
            views.setViewVisibility(R.id.four_by_one_control_prev, View.VISIBLE);
            views.setViewVisibility(R.id.four_by_one_albumart, View.GONE);
        }

        // Set correct drawable and contentDescription for pause state
        final boolean playing = service.isPlaying();
        if (playing) {
            views.setImageViewResource(R.id.four_by_one_control_play,
            		(widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.drawable.apollo_holo_light_pause:R.drawable.apollo_holo_dark_pause));
            views.setContentDescription(R.id.four_by_one_albumart,
                service.getResources().getString(R.string.nowplaying));
        } else {
            views.setImageViewResource(R.id.four_by_one_control_play,
            		(widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.drawable.apollo_holo_light_play:R.drawable.apollo_holo_dark_play));
            views.setContentDescription(R.id.four_by_one_albumart,
                service.getResources().getString(R.string.app_name));
        }

        // Link actions buttons to intents
        linkButtons(service, views, playing);

        pushUpdate(service, appWidgetIds, views);
    }

