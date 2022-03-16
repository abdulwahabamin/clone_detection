    @SuppressLint("NewApi")
	@Override
    protected Boolean doInBackground(String... params) {
    	
    	//Perform this loop procedure for each App Widget that belongs to this mApp
        for (int i=0; i < mNumWidgets; i++) {
            currentAppWidgetId = mAppWidgetIds[i];
            String widgetColor = mApp.getSharedPreferences().getString("" + currentAppWidgetId, "DARK");
            
            //Initialize the RemoteView object to gain access to the widget's UI elements.
            views = new RemoteViews(mContext.getPackageName(), R.layout.large_widget_layout);

            if (widgetColor.equals("DARK")) {
            	views.setInt(R.id.large_widget_parent_layout, "setBackgroundResource", R.drawable.appwidget_dark_bg);
            	views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_play_light);
            	views.setImageViewResource(R.id.widget_previous_track, R.drawable.btn_playback_previous_light);
            	views.setImageViewResource(R.id.widget_next_track, R.drawable.btn_playback_next_light);
            } else if (widgetColor.equals("LIGHT")) {
            	views.setInt(R.id.large_widget_parent_layout, "setBackgroundResource", R.drawable.appwidget_bg);
            	views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_play);
            	views.setImageViewResource(R.id.widget_previous_track, R.drawable.btn_playback_previous);
            	views.setImageViewResource(R.id.widget_next_track, R.drawable.btn_playback_next);
            }
            
            /* Create a pendingIntent that will serve as a general template for the clickListener.
             * We'll create a fillInIntent in LargeWidgetAdapterService.java that will provide the 
             * index of the listview item that's been clicked. */
            Intent intent = new Intent();
            intent.setAction("com.jams.music.player.WIDGET_CHANGE_TRACK");
            PendingIntent pendingIntentTemplate = PendingIntent.getBroadcast(mContext, 0, intent, 0);
            views.setPendingIntentTemplate(R.id.widget_listview, pendingIntentTemplate);
            
            //Create the intent to fire up the service that will back the adapter of the listview.
            Intent serviceIntent = new Intent(mContext, LargeWidgetAdapterService.class);
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetIds[i]);
            serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)));
            serviceIntent.putExtra("WIDGET_COLOR", widgetColor);
            
            views.setRemoteAdapter(R.id.widget_listview, serviceIntent);
            mAppWidgetManager.notifyAppWidgetViewDataChanged(mAppWidgetIds, R.id.widget_listview);
            
            //Check if the service is running and update the widget elements.
            if (mApp.isServiceRunning()) {
            	
            	//Set the album art.
        		views.setViewVisibility(R.id.widget_listview, View.VISIBLE);
        		views.setImageViewBitmap(R.id.widget_album_art, getAlbumArt());
        		
        		final Intent notificationIntent = new Intent(mContext, NowPlayingActivity.class);
                notificationIntent.putExtra("CALLED_FROM_FOOTER", true);
                notificationIntent.putExtra("CALLED_FROM_NOTIF", true);
                
                PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, notificationIntent, 0);
                views.setOnClickPendingIntent(R.id.widget_album_art, pendingIntent);
            	
            } else {
            	songTitle = "";
            	albumName = mContext.getResources().getString(R.string.no_music_playing);
            	
            	//Set the default album art.
        		views.setImageViewResource(R.id.widget_album_art, R.drawable.default_album_art);
        		views.setViewVisibility(R.id.widget_listview, View.INVISIBLE);
        		
        		if (widgetColor.equals("DARK")) {
        			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_play_light);
        		} else if (widgetColor.equals("LIGHT")) {
        			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_play);
        		}
        		
        		final Intent notificationIntent = new Intent(mContext, LauncherActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, notificationIntent, 0);
                views.setOnClickPendingIntent(R.id.widget_album_art, pendingIntent);
        		
            }
            
            //Set the song title, artist name, and album name.
            views.setTextViewText(R.id.widget_song_title_text, songTitle);
            views.setTextViewText(R.id.widget_album_text, albumName);
            views.setTextViewText(R.id.widget_artist_text, artistName);
            
            if (widgetColor.equals("LIGHT")) {
    			views.setTextColor(R.id.widget_song_title_text, Color.BLACK);
    			views.setTextColor(R.id.widget_album_text, Color.BLACK);
    			views.setTextColor(R.id.widget_artist_text, Color.BLACK);
    		}
            
            //Attach PendingIntents to the widget controls.
        	Intent previousTrackIntent = new Intent();
        	previousTrackIntent.setAction(PREVIOUS_ACTION);
        	PendingIntent previousPendingIntent = PendingIntent.getBroadcast(mContext, 0, previousTrackIntent, 0);
        	
        	Intent playPauseTrackIntent = new Intent();
        	playPauseTrackIntent.setAction(PLAY_PAUSE_ACTION);
        	PendingIntent playPausePendingIntent = PendingIntent.getBroadcast(mContext, 0, playPauseTrackIntent, 0);
        	
        	Intent nextTrackIntent = new Intent();
        	nextTrackIntent.setAction(NEXT_ACTION);
        	PendingIntent nextPendingIntent = PendingIntent.getBroadcast(mContext, 0, nextTrackIntent, 0);
        	
        	//Set the pending intents on the buttons.
            views.setOnClickPendingIntent(R.id.widget_play, playPausePendingIntent);
            views.setOnClickPendingIntent(R.id.widget_previous_track, previousPendingIntent);
            views.setOnClickPendingIntent(R.id.widget_next_track, nextPendingIntent);
            
            if (mApp.isServiceRunning()) {
            	try {
                	if (mApp.getService().getCurrentMediaPlayer().isPlaying()) {
                		if (widgetColor.equals("DARK")) {
                			views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_pause_light);
                		} else if (widgetColor.equals("LIGHT")) {
                			views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_pause);
                		}
                		
                	} else {
                		if (widgetColor.equals("DARK")) {
                			views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_play_light);
                		} else if (widgetColor.equals("LIGHT")) {
                			views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_play);
                		}
                		
                	}
            	} catch (Exception e) {
            		// TODO Auto-generated method stub
            		e.printStackTrace();
            	}
            	
            }
            
            //Tell the AppWidgetManager to perform an update on the current app widget.
            try {
            	mAppWidgetManager.updateAppWidget(currentAppWidgetId, views);
            } catch (Exception e) {
            	continue;
            }
            
        }
    	
    	return true;
    }

