    /**
     * Update all active widget instances by pushing changes
     */
    public void performUpdate(ApolloService service, int[] appWidgetIds) {
    	
    	Context mContext = service.getApplicationContext();
    	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
    	String widget_type = sp.getString( WIDGET_STYLE, mContext.getResources().getString(R.string.widget_style_light) );

    	final RemoteViews views = new RemoteViews(mContext.getPackageName(),
                (widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.layout.fourbytwo_app_widget:R.layout.fourbytwo_app_widget_dark));
        
        CharSequence artistName = service.getArtistName();
        CharSequence albumName = service.getAlbumName();
        CharSequence trackName = service.getTrackName();
        views.setTextViewText(R.id.four_by_two_artistname, artistName);
        views.setTextViewText(R.id.four_by_two_albumname, albumName);
        views.setTextViewText(R.id.four_by_two_trackname, trackName);

        // Set album art
        Bitmap bitmap = service.getAlbumBitmap();
        if (bitmap != null) {
            views.setViewVisibility(R.id.four_by_two_albumart, View.VISIBLE);
            views.setImageViewBitmap(R.id.four_by_two_albumart, bitmap);
        } else {
            views.setViewVisibility(R.id.four_by_two_albumart, View.GONE);
        }

        // Set correct drawable and contentDescription for pause state
        final boolean playing = service.isPlaying();
        if (playing) {
            views.setImageViewResource(R.id.four_by_two_control_play,
            		 (widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.drawable.butter_holo_light_pause:R.drawable.butter_holo_dark_pause));
            views.setContentDescription(R.id.four_by_two_albumart,
                service.getResources().getString(R.string.nowplaying));
        } else {
            views.setImageViewResource(R.id.four_by_two_control_play,
            		(widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.drawable.butter_holo_light_play:R.drawable.butter_holo_dark_play));
            views.setContentDescription(R.id.four_by_two_albumart,
                service.getResources().getString(R.string.butter_name));
        }

        // Set correct drawable for repeat state
        switch (service.getRepeatMode()) {
            case ApolloService.REPEAT_ALL:
                views.setImageViewResource(R.id.four_by_two_control_repeat,
                        R.drawable.butter_holo_light_repeat_all);
                break;
            case ApolloService.REPEAT_CURRENT:
                views.setImageViewResource(R.id.four_by_two_control_repeat,
                        R.drawable.butter_holo_light_repeat_one);
                break;
            default:
                views.setImageViewResource(R.id.four_by_two_control_repeat,
                		(widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.drawable.butter_holo_light_repeat_normal:R.drawable.butter_holo_light_repeat_normal));
                break;
        }

        // Set correct drawable for shuffle state
        switch (service.getShuffleMode()) {
            case ApolloService.SHUFFLE_NONE:
                views.setImageViewResource(R.id.four_by_two_control_shuffle,
                		(widget_type.equals(mContext.getResources().getString(R.string.widget_style_light))?R.drawable.butter_holo_light_shuffle_normal:R.drawable.butter_holo_light_shuffle_normal));
                break;
            case ApolloService.SHUFFLE_AUTO:
                views.setImageViewResource(R.id.four_by_two_control_shuffle,
                        R.drawable.butter_holo_light_shuffle_on);
                break;
            default:
                views.setImageViewResource(R.id.four_by_two_control_shuffle,
                        R.drawable.butter_holo_light_shuffle_on);
                break;
        }
        // Link actions buttons to intents
        linkButtons(service, views, playing);

        pushUpdate(service, appWidgetIds, views);

    }

